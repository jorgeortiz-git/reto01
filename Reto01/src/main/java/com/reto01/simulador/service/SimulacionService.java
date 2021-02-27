package com.reto01.simulador.service;

import com.reto01.simulador.entity.Simulacion;
import com.reto01.simulador.entity.Usuario;

import java.util.List;

public interface SimulacionService {
    Simulacion getSimulacionById(Long id);
//    List<Simulacion> getSimulacionByDNI(String dni);
//    List<Simulacion> getSimulaciones();
    Simulacion generarSimulacion(Simulacion simulacion);
//    void deleteUsuario(Usuario usuario);
}
