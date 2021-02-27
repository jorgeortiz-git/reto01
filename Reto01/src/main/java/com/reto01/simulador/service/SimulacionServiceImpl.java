package com.reto01.simulador.service;

import com.reto01.simulador.constants.Constants;
import com.reto01.simulador.entity.Parametro;
import com.reto01.simulador.entity.Simulacion;
import com.reto01.simulador.repository.ParametroRepository;
import com.reto01.simulador.repository.SimulacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimulacionServiceImpl implements SimulacionService {

    @Autowired
    SimulacionRepository simulacionRepository;
//    @Autowired
//    SimulacionRepositoryCustom simulacionRepositoryC;

    @Autowired
    ParametroRepository parametroRepository;

    @Autowired
    ParametroService parametroService;

//    private final List<Parametro> listaTipoTarjeta;
    private List<Parametro> listaDiaDePago = null;
//    private final List<Parametro> listaCantidadCuotas;
//    private final List<Parametro> listaTEA;
    private List<Parametro> listaParametros= null;

    public SimulacionServiceImpl() {

    }

    public SimulacionServiceImpl(ParametroService parametroService) {
        this.parametroService = parametroService;

        listaParametros =  parametroService.getParametros();
        listaDiaDePago = parametroService.getParametros();

//         listaTipoTarjeta = parametroRepository.findByNombre(Constants.PARAMETRO_TIPOTARJETA);
//         listaDiaDePago = parametroRepository.findByNombre(Constants.PARAMETRO_DIADEPAGO);
//         listaCantidadCuotas = parametroRepository.findByNombre(Constants.PARAMETRO_CUOTA);
//         listaTEA = parametroRepository.findByNombre(Constants.PARAMETRO_TEA);
    }

    public SimulacionServiceImpl(ParametroRepository parametroRepository) {
        this.parametroRepository = parametroRepository;

         listaParametros =  parametroRepository.findAll();
        listaDiaDePago = parametroRepository.findAll();

//         listaTipoTarjeta = parametroRepository.findByNombre(Constants.PARAMETRO_TIPOTARJETA);
//         listaDiaDePago = parametroRepository.findByNombre(Constants.PARAMETRO_DIADEPAGO);
//         listaCantidadCuotas = parametroRepository.findByNombre(Constants.PARAMETRO_CUOTA);
//         listaTEA = parametroRepository.findByNombre(Constants.PARAMETRO_TEA);
    }

    public Simulacion getSimulacionById(Long id) {
        Simulacion simulacion = simulacionRepository.findById(id).get();
        return simulacion;
    }

//    public List<Simulacion> getSimulacionByDNI(String dni){
//        List<Simulacion> listaDeSimulacion = simulacionRepository.obtenerSimulacionPorDNI(dni);
//        return listaDeSimulacion;
//    }

    @Override
    public Simulacion generarSimulacion(Simulacion simulacion) {
        simulacion.setFechaCreacion(LocalDateTime.now());
        simulacion.setActivo(true);

        if (validarDatosSimulacion(simulacion)) {
            simulacion.calcularCuota();
            simulacion.calcularFechaPrimeraCuota();
            simulacion.setEstado(Constants.SIMULACION_EXITOSA);
        } else {
            simulacion.setEstado(Constants.SIMULACION_ERRONEA);
        }
        return simulacionRepository.save(simulacion);
//        return simulacion = simulacionRepository.validarDatos(simulacion) ? simulacionRepository.generarSimulacion(simulacion) : simulacion;
        //return simulacion = true ? simulacionRepositoryC.generarSimulacion(simulacion) : simulacion;
    }

    public boolean validarDatosSimulacion(Simulacion simulacion) {
        List<String> listaErrores = new ArrayList<>();

        if ( simulacion.equals(null) ||
                simulacion.getTipoTarjeta().isEmpty() ||
                (simulacion.getDiaPago() == 0) ||
                (simulacion.getCantidadCuotas() == 0) ||
                (Double.compare(simulacion.getTea(),0) == 0)
        ) {
            listaErrores.add("Envío de datos vacíos");
            simulacion.setObservaciones(listaErrores.get(0));
            return false;
        }

        listaParametros = parametroRepository.findAll();
        List<Parametro> listaTipoTarjeta =  listaParametros.stream()
                .filter(tipoTarjeta -> tipoTarjeta.getNombre().compareTo(Constants.PARAMETRO_TIPOTARJETA) == 0)
                .filter(tipoTarjeta -> tipoTarjeta.getValor().toUpperCase().strip().compareTo(simulacion.getTipoTarjeta().toUpperCase().strip()) == 0 )
                .collect(Collectors.toList());
        if (listaTipoTarjeta.size() == 0) listaErrores.add(Constants.ERROR_TIPOTARJETA);
        //else simulacion.setTipoTarjetaId(Long.parseLong( listaTipoTarjeta.get(0).getValor()));


        List<Parametro> listaDiaDePago =  listaParametros.stream()
                .filter(diaDePago -> diaDePago.getNombre().compareTo(Constants.PARAMETRO_DIADEPAGO) == 0)
                .filter(diaDePago -> Integer.parseInt(diaDePago.getValor()) == simulacion.getDiaPago())
                .collect(Collectors.toList());
        if (listaDiaDePago.size() == 0) listaErrores.add(Constants.ERROR_DIADEPAGO);

        List<Parametro> listaCantidadCuotas =  listaParametros.stream()
                .filter(cantidadDeCuotas -> cantidadDeCuotas.getNombre().compareTo(Constants.PARAMETRO_CUOTA) == 0)
//                .filter(cantidadDeCuotas -> Integer.parseInt(cantidadDeCuotas.getValor()) == simulacion.getCantidadCuotas())
                .collect(Collectors.toList());
        Integer min = Integer.parseInt(listaCantidadCuotas.get(0).getValor());
        Integer max = Integer.parseInt(listaCantidadCuotas.get(1).getValor());
        if (simulacion.getCantidadCuotas() < min || simulacion.getCantidadCuotas() > max) listaErrores.add(Constants.ERROR_CUOTA);

        List<Parametro> listaTEA =  listaParametros.stream()
                .filter(tea -> tea.getNombre().compareTo(Constants.PARAMETRO_TEA) == 0)
                .filter(tea -> Double.parseDouble(tea.getValor()) == simulacion.getTea())
                .collect(Collectors.toList());
        if (listaTEA.size() == 0) listaErrores.add(Constants.ERROR_TEA);

        String str = String.join(",", listaErrores);
        System.out.println(str);
        simulacion.setObservaciones(str);

        return listaErrores.size() == 0 ? true : false;

    }
}
