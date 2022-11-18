package com.jdreyes.proyecto.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class ProveedorPk implements Serializable {

    @Column(name = "SupplierID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;

    @Column(name = "CompanyName")
    private String nombreCompanhia;

    @Column(name = "PostalCode")
    private String codigoPostal;
}
