package com.jdreyes.proyecto.web;

import com.jdreyes.proyecto.modelo.TipoReestructura;
import com.jdreyes.proyecto.servicio.PrestamoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.lang.annotation.Documented;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/prestamo")


public class PrestamoController {

    private final PrestamoService prestamoService;

    @Autowired
    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    /**
     *
     * Endpoing para obtener todos los tipos de reeestructuraciones.
     * @return lista de tipos de reestructuraciones.
     */
    @GetMapping("/tipo/all")
    @ApiOperation("Obtiene tipos de reestructuracion")
    public List<TipoReestructura> obtenerTiposReestructura() {
        return prestamoService.obtenerTiposReestructura();
    }

    @PostMapping("tipo/new")
    /**
     * Endpoing para guardar un tipo de reestructuracion.
     */
    public void guardar(@RequestBody TipoReestructura tipo) {
        prestamoService.guardar(tipo);
    }

    @PostMapping("tipo/new/v2")
    public void guardarv2(@RequestBody TipoReestructura tipo) {
        prestamoService.guardarWithSimpleJdbcInsert(tipo);
    }

    @PutMapping("tipo/update")
    public void update(@RequestBody TipoReestructura tipo) {
        prestamoService.update(tipo);
    }

    @DeleteMapping("tipo/delete/{id}")
    public void delete(@PathVariable Integer id) {
        prestamoService.eliminar(id);
    }

    @GetMapping("tipo/find/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        return prestamoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

}
