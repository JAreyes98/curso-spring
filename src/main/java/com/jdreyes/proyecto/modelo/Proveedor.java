package com.jdreyes.proyecto.modelo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "Suppliers")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProveedor")
public class Proveedor {

    @Id
    @Column(name = "SupplierID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;

    @Id
    @Column(name = "CompanyName")
    private String nombreCompanhia;

    @Column(name = "ContactName")
    private String nombreContacto;

    @Column(name = "Address")
    private String direccion;

    @Column(name = "City")
    private String ciudad;

    @ManyToOne
    @JoinColumn(name = "Region", referencedColumnName = "RegionID")
    private Region region;

    @Id
    @Column(name = "PostalCode")
    private String codigoPostal;

    @Column(name = "Country")
    private String pais;

    @Column(name = "Phone")
    private String telefono;

}
