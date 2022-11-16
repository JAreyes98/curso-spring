package com.jdreyes.proyecto.servicio;

import com.jdreyes.proyecto.modelo.Territorio;
import com.jdreyes.proyecto.repo.dao.TerritorioDAO;
import com.jdreyes.proyecto.repo.dao.TerritorioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TerritorioService {

    private final TerritorioDAO TerritorioDAO;

    @Autowired
    public TerritorioService(TerritorioDAO TerritorioDAO) {
        this.TerritorioDAO = TerritorioDAO;
    }

    public List<Territorio> obtenerTerritorio() {
        return TerritorioDAO.obtenerTerritorioes();
    }

    public Optional<Territorio> obtenerTerritorioById(Integer id) {
        return TerritorioDAO.obtenerTerritorioById(id).stream().findFirst();
    }

    public Territorio nuevaTerritorio(Territorio r) {
        return TerritorioDAO.nuevaTerritorio(r);
    }
}
