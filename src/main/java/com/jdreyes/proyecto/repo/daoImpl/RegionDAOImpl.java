package com.jdreyes.proyecto.repo.daoImpl;

import com.jdreyes.proyecto.modelo.Region;
import com.jdreyes.proyecto.repo.dao.RegionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class RegionDAOImpl implements RegionDAO {

    private final JdbcTemplate template;

    @Autowired
    public RegionDAOImpl(JdbcTemplate template) {
        this.template = template;
    }

    public List<Region> obtenerRegiones() {
        return template.query("select " +
                        "RegionID as idRegion" +
                        ", RegionDescription as descRegion" +
                        " from Region"
                , BeanPropertyRowMapper.newInstance(Region.class));
    }

    public List<Region> obtenerRegionById(Integer id) {
        return template.query("select " +
                        "RegionID as idRegion" +
                        ", RegionDescription as descRegion where RegionID=?" +
                        " from Region"
                , BeanPropertyRowMapper.newInstance(Region.class)
                , id);
    }

    public Region nuevaRegion(Region region) {
        Map<String, Object> map = new HashMap<>();
        map.put("RegionID", region.getIdRegion());
        map.put("RegionDescription", region.getDescRegion());

        SimpleJdbcInsert insert = new SimpleJdbcInsert(template).withTableName("Region");
        insert.execute(map);
        return region;
    }
}
