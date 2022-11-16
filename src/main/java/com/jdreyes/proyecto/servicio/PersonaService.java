package com.jdreyes.proyecto.servicio;

import com.jdreyes.proyecto.modelo.entities.Persona;
import com.jdreyes.proyecto.repo.crud.PersonaCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaCRUD personaCRUD;

    @Autowired
    public PersonaService(PersonaCRUD personaCRUD) {
        this.personaCRUD = personaCRUD;
    }

    public Iterable<Persona> obtenerTodo() {
        return personaCRUD.findAll();
    }

    public Persona guardar(Persona persona) {
        return personaCRUD.save(persona);
    }

    public Optional<Persona> byId(Integer id) {
        return personaCRUD.findById(id);
    }

    public void eliminar(Integer id) {
        byId(id).ifPresent(personaCRUD::delete);
    }


}
