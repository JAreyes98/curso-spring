package com.jdreyes.proyecto.servicio;

import com.jdreyes.proyecto.modelo.Proveedor;
import com.jdreyes.proyecto.repo.crud.ProveedorCRUD;
import com.jdreyes.proyecto.repo.dao.ProveedorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    private final ProveedorDAO ProveedorDAO;
    private final ProveedorCRUD proveedorCRUD;

    @Autowired
    public ProveedorService(ProveedorDAO ProveedorDAO, ProveedorCRUD proveedorCRUD) {
        this.ProveedorDAO = ProveedorDAO;
        this.proveedorCRUD = proveedorCRUD;
    }

    public List<Proveedor> obtenerProveedor() {
//        return ProveedorDAO.obtenerProveedores();
        return (List<Proveedor>) proveedorCRUD.findAll();
    }

    public Optional<Proveedor> obtenerProveedorById(Integer id) {
//        return ProveedorDAO.obtenerProveedorById(id).stream().findFirst();
        return proveedorCRUD.findById(id);
    }

    public Proveedor nuevaProveedor(Proveedor r) {
//        return ProveedorDAO.nuevaProveedor(r);
        return proveedorCRUD.save(r);
    }
}
