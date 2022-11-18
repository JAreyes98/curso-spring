package com.jdreyes.proyecto.repo.dao;

import com.jdreyes.proyecto.modelo.Region;

import java.util.List;
import java.util.Optional;

public interface RegionDAO {
    List<Region> obtenerRegiones();
    Optional<Region> obtenerRegionById(Integer id);
    ;Region nuevaRegion(Region region);
}
