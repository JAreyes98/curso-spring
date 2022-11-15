package com.jdreyes.proyecto.repo.daoImpl;

import com.jdreyes.proyecto.modelo.TipoReestructura;
import com.jdreyes.proyecto.repo.dao.TipoEstructuraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class TipoEstructuraDAOImpl implements TipoEstructuraDAO {

    private final JdbcTemplate template;

    @Autowired
    public TipoEstructuraDAOImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<TipoReestructura> todo() {
        return template.query("SELECT N_TIPO as tipo" +
                        ", C_DESCRIPCION as [desc]  " +
                        ", D_FECHA_REGISTRO as fecha  " +
                        ", C_ESTATUS as estatus  " +
                        "FROM R_TIPO_REESTRUCTURADO"
                , BeanPropertyRowMapper.newInstance(TipoReestructura.class));
        //, new TipoReestructuraRowMapper()
//        BeanPropertyRowMapper.newInstance(TipoReestructura.class)
    }

    @Override
    public Optional<TipoReestructura> obtenerPorId(Integer id) {
        return template.query("SELECT top 1 N_TIPO as tipo" +
                                ", C_DESCRIPCION as [desc]  " +
                                ", D_FECHA_REGISTRO as fecha  " +
                                ", C_ESTATUS as estatus  " +
                                "FROM R_TIPO_REESTRUCTURADO WHERE N_TIPO = ?"
                        , BeanPropertyRowMapper.newInstance(TipoReestructura.class), id)
                .stream().findFirst();
    }

    @Override
    public void guardar(TipoReestructura tipo) {
        template.update("insert into R_TIPO_REESTRUCTURADO(N_TIPO, C_DESCRIPCION, D_FECHA_REGISTRO, C_ESTATUS) " +
                "VALUES(?, ?, ?, ?)", tipo.getTipo(), tipo.getDesc(), tipo.getFecha(), tipo.getEstatus());
    }

    @Override
    public void guardarWithSimpleJdbcInsert(TipoReestructura tipo) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(template)
                .withTableName("R_TIPO_REESTRUCTURADO");

        Map<String, Object> map = new HashMap<>();
        map.put("N_TIPO", tipo.getTipo());
        map.put("C_DESCRIPCION", tipo.getDesc());
        map.put("D_FECHA_REGISTRO", tipo.getFecha());
        map.put("C_ESTATUS", tipo.getEstatus());
        insert.execute(map);
    }

    @Override
    public void actualizar(TipoReestructura tipo) {
        template.update("update R_TIPO_REESTRUCTURADO set C_DESCRIPCION = ?" +
                        ", D_FECHA_REGISTRO = ?" +
                        ", C_ESTATUS = ?" +
                        " WHERE R_TIPO_REESTRUCTURADO N_TIPO = ? "
                , tipo.getDesc(), tipo.getFecha(), tipo.getEstatus(), tipo.getTipo());
    }

    public void eliminar(Integer tipo) {
        template.update("delete from R_TIPO_REESTRUCTURADO WHERE N_TIPO = ? ", tipo);
    }
}
