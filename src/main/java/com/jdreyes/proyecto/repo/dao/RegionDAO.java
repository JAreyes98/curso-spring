package com.jdreyes.proyecto.repo.dao;

import com.jdreyes.proyecto.modelo.Region;

import java.util.List;

public interface RegionDAO {
    List<Region> obtenerRegiones();
    List<Region> obtenerRegionById(Integer id);
    ;Region nuevaRegion(Region region);
}
