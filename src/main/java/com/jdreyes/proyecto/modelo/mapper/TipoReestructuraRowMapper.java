package com.jdreyes.proyecto.modelo.mapper;

import com.jdreyes.proyecto.modelo.TipoReestructura;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoReestructuraRowMapper implements RowMapper<TipoReestructura> {

    @Override
    public TipoReestructura mapRow(ResultSet rs, int rowNum) throws SQLException {
        TipoReestructura tipo = new TipoReestructura();
        tipo.setTipo(rs.getShort("N_TIPO"));
        tipo.setDesc(rs.getString("C_DESCRIPCION"));
        tipo.setFecha(rs.getTimestamp("D_FECHA_REGISTRO"));
        tipo.setEstatus(rs.getString("C_ESTATUS"));
        return tipo;
    }
}
