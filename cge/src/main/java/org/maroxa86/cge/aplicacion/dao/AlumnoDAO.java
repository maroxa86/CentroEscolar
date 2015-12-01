package org.maroxa86.cge.aplicacion.dao;

import java.util.List;

import org.maroxa86.cge.aplicacion.bo.Alumno;
import org.maroxa86.cge.aplicacion.bo.Curso;

public interface AlumnoDAO extends GenericDAO<Alumno, String> {
    List<Alumno> buscarPorCurso(Curso curso);

}