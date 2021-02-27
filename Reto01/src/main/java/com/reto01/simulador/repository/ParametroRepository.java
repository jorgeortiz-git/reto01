package com.reto01.simulador.repository;

import com.reto01.simulador.entity.Parametro;
import com.reto01.simulador.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParametroRepository extends JpaRepository <Parametro, Long> {

    //List<Parametro> findByNombre(String nombre);
//    List<Parametro> findAllParametros();
}
