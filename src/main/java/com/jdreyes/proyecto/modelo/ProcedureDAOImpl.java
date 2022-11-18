package com.jdreyes.proyecto.modelo;

import com.jdreyes.proyecto.modelo.entities.Persona;
import com.jdreyes.proyecto.repo.dao.ProcedureDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProcedureDAOImpl implements ProcedureDAO {

    private final JdbcTemplate template;

    @Autowired
    public ProcedureDAOImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Persona> obtenerTodas() {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(template)
                .withProcedureName("SP_GENTE")
                .returningResultSet("resultado"
                        , BeanPropertyRowMapper.newInstance(Persona.class));
        Map<String, Object> out = jdbcCall.execute();
        return (List<Persona>) out.get("resultado");
    }
}
