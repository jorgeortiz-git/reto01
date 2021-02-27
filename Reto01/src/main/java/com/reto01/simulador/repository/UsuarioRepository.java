package com.reto01.simulador.repository;

import com.reto01.simulador.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

    Usuario findByNombre(String nombre);
//    List<Usuario> findAllUsuarios();
}
