package com.reto01.simulador.repository;

import com.reto01.simulador.constants.Constants;
import com.reto01.simulador.entity.Simulacion;
import com.reto01.simulador.entity.Usuario;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

public abstract class SimulacionRepositoryImpl implements SimulacionRepository {

    @Autowired
    SimulacionRepository simulacionRepository;

}
