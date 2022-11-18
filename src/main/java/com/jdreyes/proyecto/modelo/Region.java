package com.jdreyes.proyecto.modelo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name = "Region")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idRegion")
public class Region {

    @Id
    @Column(name = "RegionID")
    private Integer idRegion;

    @Column(name = "RegionDescription")
    private String descRegion;

    @OneToMany(mappedBy = "region")
    List<Territorio> territorios;
}
