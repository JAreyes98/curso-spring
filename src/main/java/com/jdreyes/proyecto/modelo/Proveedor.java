package com.jdreyes.proyecto.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Proveedor {

    private Integer idProveedor;
    private String nombreCompanhia;
    private String nombreContacto;
    private String direccion;
    private String ciudad;
    private String region;
    private String pais;
    private String telefono;

}
