package com.jdreyes.proyecto.modelo.mapper;

import com.jdreyes.proyecto.modelo.entities.Persona;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaMapper  implements RowMapper<Persona> {


    @Override
    public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
        Persona p = new Persona();
        p.setId(rs.getInt("id"));
        p.setPp(rs.getString("pp"));
        p.setSp(rs.getString("ps"));
        p.setPa(rs.getString("pa"));
        p.setSa(rs.getString("sa"));
        return p;
    }
}
