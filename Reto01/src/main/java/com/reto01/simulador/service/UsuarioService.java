package com.reto01.simulador.service;

import com.reto01.simulador.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario getUsuarioById(Long id);
    Usuario getUsuarioByNombre(String nombre);
    List<Usuario> getUsuarios();
    Usuario saveUsuario(Usuario usuario);
    void deleteUsuario(Usuario usuario);
}
