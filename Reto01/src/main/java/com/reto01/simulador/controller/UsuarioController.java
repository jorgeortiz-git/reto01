package com.reto01.simulador.controller;

import com.reto01.simulador.entity.Usuario;
import com.reto01.simulador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/obtenerUsuario/{id}")
    public Usuario obtenerUsuario(@PathVariable Long id) { return usuarioService.getUsuarioById(id); }

    @GetMapping("/obtenerUsuarios")
    public List<Usuario> obtenerUsuarios() { return usuarioService.getUsuarios(); }

    @RequestMapping(value="obtenerUsuarioPorNombre", method = RequestMethod.GET)
    public Usuario obtenerUsuario(@RequestParam(value = "nombre") String nombre){
        return usuarioService.getUsuarioByNombre(nombre);
    }

    @PostMapping(path = "/usuario", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
        Usuario newUsuario = usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(newUsuario);
    }
}
