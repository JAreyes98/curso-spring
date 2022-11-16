package com.jdreyes.proyecto.repo.crud;


import com.jdreyes.proyecto.modelo.entities.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaCRUD extends CrudRepository<Persona, Integer> {
}
