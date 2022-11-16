package com.jdreyes.proyecto.web;

import com.jdreyes.proyecto.modelo.Region;
import com.jdreyes.proyecto.servicio.RegionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

public class RegionController {

    private final RegionService service;

    @Autowired
    public RegionController(RegionService service) {
        this.service = service;
    }

    @GetMapping("/")
    @ApiOperation("Obtiene todos los registros de Region")
    public ResponseEntity<List<Region>> obtenerTodo() {
        return ResponseEntity.ok(service.obtenerRegiones());
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtiene todos los registros de Region")
    public ResponseEntity<Region> obtenerId(@ApiParam("Id de Region es requerido")
                                            @PathVariable Integer id) {
        return service.obtenerRegionById(id).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping("/new")
    @ApiOperation("Registra una nueva Region")
    public ResponseEntity<Region> nuevo(@ApiParam("Region: requerido")
                                            @RequestBody Region r) {
        return ResponseEntity.ok(service.nuevaRegion(r));
    }

}
