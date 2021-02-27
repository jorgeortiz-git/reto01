package com.reto01.simulador.service;

import com.reto01.simulador.entity.Parametro;
import com.reto01.simulador.entity.Usuario;

import java.util.List;

public interface ParametroService {
    Parametro getParametroById(Long id);
//    Usuario getParametroByNombre(String nombre);
    List<Parametro> getParametros();
    Parametro saveParametro(Parametro parametro);
//    void deleteUsuario(Usuario usuario);
}
