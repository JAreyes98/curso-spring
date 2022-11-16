package com.jdreyes.proyecto.servicio;

import com.jdreyes.proyecto.modelo.Region;
import com.jdreyes.proyecto.repo.dao.RegionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {
    private final RegionDAO regionDAO;

    @Autowired
    public RegionService(RegionDAO regionDAO) {
        this.regionDAO = regionDAO;
    }

    public List<Region> obtenerRegiones() {
        return regionDAO.obtenerRegiones();
    }

    public Optional<Region> obtenerRegionById(Integer id) {
        return regionDAO.obtenerRegionById(id).stream().findFirst();
    }

    public Region nuevaRegion(Region r) {
        return regionDAO.nuevaRegion(r);
    }
}
