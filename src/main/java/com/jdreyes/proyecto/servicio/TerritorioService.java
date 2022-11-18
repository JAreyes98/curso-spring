package com.jdreyes.proyecto.servicio;

import com.jdreyes.proyecto.modelo.Territorio;
import com.jdreyes.proyecto.repo.crud.TerritorioCRUD;
import com.jdreyes.proyecto.repo.dao.TerritorioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TerritorioService {

    private final TerritorioDAO TerritorioDAO;
    private final TerritorioCRUD territorioCRUD;

    @Autowired
    public TerritorioService(TerritorioDAO TerritorioDAO, TerritorioCRUD territorioCRUD) {
        this.TerritorioDAO = TerritorioDAO;
        this.territorioCRUD = territorioCRUD;
    }

    public List<Territorio> obtenerTerritorio() {
//        return TerritorioDAO.obtenerTerritorioes();
        return (List<Territorio>) territorioCRUD.findAll();
    }

    public Optional<Territorio> obtenerTerritorioById(Integer id) {
//        return TerritorioDAO.obtenerTerritorioById(id).stream().findFirst();
        return territorioCRUD.findById(id);
    }

    public Territorio nuevaTerritorio(Territorio r) {
//        return TerritorioDAO.nuevaTerritorio(r);
        return territorioCRUD.save(r);
    }
}
