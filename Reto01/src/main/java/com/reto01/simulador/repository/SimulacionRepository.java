package com.reto01.simulador.repository;

import com.reto01.simulador.entity.Simulacion;
import com.reto01.simulador.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimulacionRepository extends JpaRepository <Simulacion, Long> {

//    Simulacion generarSimulacion(/*Simulacion simulacion*/);
//    List<Simulacion> obtenerSimulacionPorDNI(String dni);
//    boolean validarDatos (Simulacion simulacion);
//    Simulacion saveSimulacion(Simulacion simulacion);
}
