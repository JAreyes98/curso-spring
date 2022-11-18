package com.jdreyes.proyecto.repo.crud;

import com.jdreyes.proyecto.modelo.Territorio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerritorioCRUD extends CrudRepository<Territorio, Integer> {
    List<Territorio> findAllByDescTerritorioEquals(String territry);
}
