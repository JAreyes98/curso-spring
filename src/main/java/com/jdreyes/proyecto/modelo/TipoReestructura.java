package com.jdreyes.proyecto.modelo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class TipoReestructura {

    private Short tipo;
    private String desc;
    private Timestamp fecha;
    private String estatus;
}
