package com.jdreyes.proyecto.repo.crud;

import com.jdreyes.proyecto.modelo.Region;
import com.jdreyes.proyecto.modelo.Territorio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RegionCRUD extends CrudRepository<Region, Integer> {
}
