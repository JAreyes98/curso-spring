package com.jdreyes.proyecto.modelo.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Persona")
@Getter
@Setter
@EqualsAndHashCode
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pp;
    private String sp;
    private String pa;
    private String sa;
}
