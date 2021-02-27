package com.reto01.simulador.service;

import com.reto01.simulador.entity.Parametro;
import com.reto01.simulador.entity.Usuario;
import com.reto01.simulador.repository.ParametroRepository;
import com.reto01.simulador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class ParametroServiceImpl implements ParametroService {

    @Autowired
    ParametroRepository parametroRepository;

    public Parametro getParametroById(Long id) {
        Parametro parametro = parametroRepository.findById(id).get();
        return parametro;
    }

//    public Usuario getUsuarioByNombre(String nombre){
//        Usuario Usuario = usuarioRepository.findByNombre(nombre);
//        return Usuario;
//    }

    public List<Parametro> getParametros(){
        List<Parametro> listaDeParametros = parametroRepository.findAll();
        return listaDeParametros;
    }

    public Parametro saveParametro(Parametro parametro){
        Parametro newParametro = parametroRepository.save(parametro);
        return newParametro;
    }

//    public void deleteUsuario(Usuario usuario){
//        usuarioRepository.delete(usuario);
//    }
}
