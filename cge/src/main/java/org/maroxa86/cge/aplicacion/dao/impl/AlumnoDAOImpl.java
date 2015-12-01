package org.maroxa86.cge.aplicacion.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.maroxa86.cge.aplicacion.bo.Alumno;
import org.maroxa86.cge.aplicacion.bo.Curso;
import org.maroxa86.cge.aplicacion.dao.AlumnoDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AlumnoDAOImpl extends GenericDAOImpl<Alumno, String>implements AlumnoDAO {

    private static final Logger LOGGER = Logger.getLogger(AlumnoDAOImpl.class.getPackage().getName());

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> buscarPorCurso(Curso curso) {
        LOGGER.info("Inicio - buscarPorCurso --> curso: " + curso);
        List<Alumno> listaDeAlumno = null;
        TypedQuery<Alumno> consulta = getManager().createQuery("Select l from Alumno l where l.curso=?1", Alumno.class);
        consulta.setParameter(1, curso);
        listaDeAlumno = consulta.getResultList();
        LOGGER.info("Fin - buscarPorCurso");
        return listaDeAlumno;
    }
}
