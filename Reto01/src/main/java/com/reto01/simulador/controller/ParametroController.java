package com.reto01.simulador.controller;

import com.reto01.simulador.entity.Parametro;
import com.reto01.simulador.entity.Usuario;
import com.reto01.simulador.service.ParametroService;
import com.reto01.simulador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/param")
public class ParametroController {

    @Autowired
    ParametroService parametroService;

    @GetMapping("/obtenerParametro/{id}")
    public Parametro obtenerParametro(@PathVariable Long id) { return parametroService.getParametroById(id); }

    @GetMapping("/obtenerParametros")
    public List<Parametro> obtenerParametros() { return parametroService.getParametros(); }

//    @RequestMapping(value="obtenerUsuarioPorNombre", method = RequestMethod.GET)
//    public Usuario obtenerUsuario(@RequestParam(value = "nombre") String nombre){
//        return parametroService.getUsuarioByNombre(nombre);
//    }
//
//    @PostMapping(path = "/usuario", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
//        Usuario newUsuario = parametroService.saveUsuario(usuario);
//        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(newUsuario);
//    }
}
