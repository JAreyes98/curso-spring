package com.jdreyes.proyecto.web;

import com.jdreyes.proyecto.modelo.entities.Persona;
import com.jdreyes.proyecto.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonController {

    private final PersonaService service;

    @Autowired
    public PersonController(PersonaService service) {
        this.service = service;
    }


    @GetMapping("/")
    public ResponseEntity<Iterable<Persona>> todo() {
        return ResponseEntity.ok(service.obtenerTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> id(@PathVariable Integer id) {
        return ResponseEntity.ok(service.byId(id).orElseGet(() -> null));
    }

    @PostMapping("/new")
    public ResponseEntity<Persona> save(@RequestBody Persona persona) {
        return ResponseEntity.ok(service.guardar(persona));
    }

    @DeleteMapping("/del")
    public ResponseEntity<?> del(@RequestBody Persona persona) {
        service.eliminar(persona.getId());
        return service.byId((persona.getId())).isEmpty() ? ResponseEntity.ok("ELIMINADO") : ResponseEntity.badRequest().body("NEL, NO SE PUDO PRRO");
    }
}
