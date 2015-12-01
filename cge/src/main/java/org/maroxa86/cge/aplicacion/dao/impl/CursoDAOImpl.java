package org.maroxa86.cge.aplicacion.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.maroxa86.cge.aplicacion.bo.Curso;
import org.maroxa86.cge.aplicacion.dao.CursoDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CursoDAOImpl extends GenericDAOImpl<Curso, Integer>implements CursoDAO {

    private static final Logger LOGGER = Logger.getLogger(CursoDAOImpl.class.getPackage().getName());
    
    @Transactional(readOnly = true)
    public List<Curso> buscarTodos() {
        LOGGER.info("Inicio - buscarTodos");
        List<Curso> listaDeCursos = null;
    	TypedQuery<Curso> consulta = getManager().createQuery("SELECT l FROM Curso l", Curso.class);
    	listaDeCursos = consulta.getResultList();
        LOGGER.info("Fin - buscarTodos");
        return listaDeCursos;
    }

}
