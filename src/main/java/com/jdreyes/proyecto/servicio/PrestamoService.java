package com.jdreyes.proyecto.servicio;

import com.jdreyes.proyecto.modelo.TipoReestructura;
import com.jdreyes.proyecto.repo.dao.TipoEstructuraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {

    private final TipoEstructuraDAO tipoEstructuraDAO;

    @Autowired
    public PrestamoService(TipoEstructuraDAO tipoEstructuraDAO) {
        this.tipoEstructuraDAO = tipoEstructuraDAO;
    }

    public List<TipoReestructura> obtenerTiposReestructura() {
        return tipoEstructuraDAO.todo();
    }
    public Optional<TipoReestructura> obtenerPorId(Integer id) {
        return tipoEstructuraDAO.obtenerPorId(id);
    }

    public void guardar(TipoReestructura tipo) {
        tipoEstructuraDAO.guardar(tipo);
    }

    public void guardarWithSimpleJdbcInsert(TipoReestructura tipo) {
        tipoEstructuraDAO.guardarWithSimpleJdbcInsert(tipo);
    }

    public void update(TipoReestructura tipo) {
        tipoEstructuraDAO.actualizar(tipo);
    }
    public void eliminar(Integer tipo) {
        tipoEstructuraDAO.eliminar(tipo);
    }
}
