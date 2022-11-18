package com.jdreyes.proyecto.repo.dao;

import com.jdreyes.proyecto.modelo.entities.Persona;

import java.util.List;

public interface ProcedureDAO {
    List<Persona> obtenerTodas();
}
