package com.reto01.simulador.service;

import com.reto01.simulador.entity.Usuario;
import com.reto01.simulador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario getUsuarioById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        return usuario;
    }

    public Usuario getUsuarioByNombre(String nombre){
        Usuario Usuario = usuarioRepository.findByNombre(nombre);
        return Usuario;
    }

    public List<Usuario> getUsuarios(){
        List<Usuario> listaDeUsuarios = usuarioRepository.findAll();
        return listaDeUsuarios;
    }

    public Usuario saveUsuario(Usuario usuario){
        Usuario newUsuario = usuarioRepository.save(usuario);
        return newUsuario;
    }

    public void deleteUsuario(Usuario usuario){
        usuarioRepository.delete(usuario);
    }
}
