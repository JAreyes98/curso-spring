package com.jdreyes.proyecto.repo.dao;

import com.jdreyes.proyecto.modelo.Territorio;

import java.util.List;

public interface TerritorioDAO {
    List<Territorio> obtenerTerritorioes();
    List<Territorio> obtenerTerritorioById(Integer id);
    Territorio nuevaTerritorio(Territorio Territorio);
}
