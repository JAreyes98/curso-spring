package com.jdreyes.proyecto.repo.dao;

import com.jdreyes.proyecto.modelo.TipoReestructura;

import java.util.List;
import java.util.Optional;

public interface TipoEstructuraDAO {
    List<TipoReestructura> todo();
    Optional<TipoReestructura> obtenerPorId(Integer id);
    void guardar(TipoReestructura tipo);
    void guardarWithSimpleJdbcInsert(TipoReestructura tipo);
    void actualizar(TipoReestructura tipo);
    void eliminar(Integer tipo);
}
