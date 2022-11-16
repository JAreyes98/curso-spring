package com.jdreyes.proyecto.repo.dao;

import com.jdreyes.proyecto.modelo.Proveedor;

import java.util.List;

public interface ProveedorDAO {

    List<Proveedor> obtenerProveedores();
    List<Proveedor> obtenerProveedorById(Integer id);
    Proveedor nuevaProveedor(Proveedor Proveedor);
}
