package com.jdreyes.proyecto.servicio;

import com.jdreyes.proyecto.modelo.Proveedor;
import com.jdreyes.proyecto.repo.dao.ProveedorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    private final ProveedorDAO ProveedorDAO;

    @Autowired
    public ProveedorService(ProveedorDAO ProveedorDAO) {
        this.ProveedorDAO = ProveedorDAO;
    }

    public List<Proveedor> obtenerProveedor() {
        return ProveedorDAO.obtenerProveedores();
    }

    public Optional<Proveedor> obtenerProveedorById(Integer id) {
        return ProveedorDAO.obtenerProveedorById(id).stream().findFirst();
    }

    public Proveedor nuevaProveedor(Proveedor r) {
        return ProveedorDAO.nuevaProveedor(r);
    }
}
