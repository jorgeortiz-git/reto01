package com.reto01.simulador.repository;

import com.reto01.simulador.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class  UsuarioRepositoryImpl implements UsuarioRepository {

    @Autowired
    UsuarioRepository usuarioRepository;

//    @Override
//    public Usuario findByNombre(String nombre) {
//        return null;
//    }
//    public List<Usuario> findAllUsuarios() {
//        return usuarioRepository.findAll();
//    }
}
