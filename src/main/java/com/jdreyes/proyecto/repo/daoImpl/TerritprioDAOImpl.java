package com.jdreyes.proyecto.repo.daoImpl;

import com.jdreyes.proyecto.modelo.Territorio;
import com.jdreyes.proyecto.modelo.Territorio;
import com.jdreyes.proyecto.repo.dao.TerritorioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TerritprioDAOImpl implements TerritorioDAO {

    private final JdbcTemplate template;

    @Autowired
    public TerritprioDAOImpl(JdbcTemplate template) {
        this.template = template;
    }

    public List<Territorio> obtenerTerritorioes() {
        return template.query("select " +
                        "TerritoryID as idTerritorio" +
                        ", TerritoryDescription as descTerritorio from Territories"
                , BeanPropertyRowMapper.newInstance(Territorio.class));
    }

    public List<Territorio> obtenerTerritorioById(Integer id) {
        return template.query("select " +
                        "TerritoryID as idTerritorio" +
                        ", TerritoryDescription as descTerritorio FROM Territories WHERE TerritoryID=?"
                , BeanPropertyRowMapper.newInstance(Territorio.class)
                , id);
    }

    public Territorio nuevaTerritorio(Territorio pro) {
        Map<String, Object> map = new HashMap<>();
        map.put("TerritoryID", pro.getIdTerritorio());
        map.put("TerritoryDescription", pro.getDescTerritorio());
        map.put("RegionID", 1);

        SimpleJdbcInsert insert = new SimpleJdbcInsert(template).withTableName("Territories");
        insert.execute(map);
        return pro;
    }
}
