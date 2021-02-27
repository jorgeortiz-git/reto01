package com.reto01.simulador.repository;

import com.reto01.simulador.entity.Parametro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


public abstract class ParametroRepositoryImpl implements ParametroRepository {
    @Autowired
    ParametroRepository parametroRepository;

//    @Override
//    public List<Parametro> findByNombre(String nombre) {
//        return null;
//    }
//    @Override
//    public List<Parametro> findAllParametros() {
//        return parametroRepository.findAll();
//    };
}
