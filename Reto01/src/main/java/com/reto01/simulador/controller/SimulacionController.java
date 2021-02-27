package com.reto01.simulador.controller;

import com.reto01.simulador.entity.Simulacion;
import com.reto01.simulador.entity.Usuario;
import com.reto01.simulador.service.SimulacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simulador")
public class SimulacionController {

    @Autowired
    SimulacionService simulacionService;

    @GetMapping("/obtenerSimulacion/{id}")
    public Simulacion obtenerSimulacion(@PathVariable Long id) {
        return simulacionService.getSimulacionById(id);
    }

//    @GetMapping("/obtenerUsuarios")
//    public List<Usuario> obtenerUsuarios() { return usuarioService.getUsuarios(); }
//

    @PostMapping(path = "/simulacion", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Simulacion> guardarSimulacion(@RequestBody Simulacion simulacion){
//    @PostMapping(path = "/simulacion")
//    public ResponseEntity<Simulacion> guardarSimulacion(){
        Simulacion newSimulacion = simulacionService.generarSimulacion(simulacion);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(newSimulacion);
    }
}
