package com.jdreyes.proyecto.web;

import com.jdreyes.proyecto.modelo.Proveedor;
import com.jdreyes.proyecto.servicio.ProveedorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class ProveedorController {

    private final ProveedorService service;

    @Autowired
    public ProveedorController(ProveedorService service) {
        this.service = service;
    }

    @GetMapping("/")
    @ApiOperation("Obtiene todos los registros de Proveedor")
    public ResponseEntity<List<Proveedor>> obtenerTodo() {
        return ResponseEntity.ok(service.obtenerProveedor());
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtiene todos los registros de Proveedor")
    public ResponseEntity<Proveedor> obtenerId(@ApiParam("Id de Proveedor es requerido")
                                            @PathVariable Integer id) {
        return service.obtenerProveedorById(id).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping("/new")
    @ApiOperation("Registra una nueva Proveedor")
    public ResponseEntity<Proveedor> nuevo(@ApiParam("Proveedor: requerido")
                                            @RequestBody Proveedor r) {
        return ResponseEntity.ok(service.nuevaProveedor(r));
    }

}
