package com.jdreyes.proyecto.web;

import com.jdreyes.proyecto.modelo.Territorio;
import com.jdreyes.proyecto.servicio.TerritorioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/territory")
public class TerritorioController {

    private final TerritorioService service;

    @Autowired
    public TerritorioController(TerritorioService service) {
        this.service = service;
    }

    @GetMapping("/")
    @ApiOperation("Obtiene todos los registros de Territorio")
    public ResponseEntity<List<Territorio>> obtenerTodo() {
        return ResponseEntity.ok(service.obtenerTerritorio());
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtiene todos los registros de Territorio")
    public ResponseEntity<Territorio> obtenerId(@ApiParam("Id de Territorio es requerido")
                                            @PathVariable Integer id) {
        return service.obtenerTerritorioById(id).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping("/new")
    @ApiOperation("Registra una nueva Territorio")
    public ResponseEntity<Territorio> nuevo(@ApiParam("Territorio: requerido")
                                            @RequestBody Territorio r) {
        return ResponseEntity.ok(service.nuevaTerritorio(r));
    }

}
