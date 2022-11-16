package com.jdreyes.proyecto.repo.daoImpl;

import com.jdreyes.proyecto.modelo.Proveedor;
import com.jdreyes.proyecto.modelo.Proveedor;
import com.jdreyes.proyecto.repo.dao.ProveedorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProveedorDAOImpl implements ProveedorDAO {

    private final JdbcTemplate template;

    @Autowired
    public ProveedorDAOImpl(JdbcTemplate template) {
        this.template = template;
    }

    public List<Proveedor> obtenerProveedores() {
        return template.query("select " +
                        "SupplierID as idProveedor" +
                        ", CompanyName as nombreCompanhia" +
                        ", ContactName as nombreContacto" +
                        ", Address as direccion" +
                        ", City as ciudad" +
                        ", Region as region" +
                        ", Country as pais" +
                        ", Phone as telefono" +
                        " from Suppliers"
                , BeanPropertyRowMapper.newInstance(Proveedor.class));
    }

    public List<Proveedor> obtenerProveedorById(Integer id) {
        return template.query("select " +
                        "SupplierID as idProveedor" +
                        ", CompanyName as nombreCompanhia" +
                        ", ContactName as nombreContacto" +
                        ", Address as direccion" +
                        ", City as ciudad" +
                        ", Region as region" +
                        ", Country as pais" +
                        ", Phone as telefono" +
                        " where ProveedorID=?" +
                        " from Suppliers"
                , BeanPropertyRowMapper.newInstance(Proveedor.class)
                , id);
    }

    public Proveedor nuevaProveedor(Proveedor pro) {
        Map<String, Object> map = new HashMap<>();
        map.put("CompanyName", pro.getNombreCompanhia());
        map.put("ContactName", pro.getNombreContacto());
        map.put("Address", pro.getDireccion());
        map.put("City", pro.getCiudad());
        map.put("Region", pro.getRegion());
        map.put("Country", pro.getPais());
        map.put("Phone", pro.getTelefono());

        SimpleJdbcInsert insert = new SimpleJdbcInsert(template).withTableName("Suppliers")
                        .usingGeneratedKeyColumns("SupplierID");
        Number key = insert.executeAndReturnKey(map);
        pro.setIdProveedor(key.intValue());
        return pro;
    }
}
