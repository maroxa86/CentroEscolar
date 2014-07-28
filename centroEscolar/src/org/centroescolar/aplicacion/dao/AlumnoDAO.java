package org.centroescolar.aplicacion.dao;

import java.util.List;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;

public interface AlumnoDAO extends GenericDAO<Alumno,String>{
	public Alumno BuscarAlumno(int id);
	public List<Alumno> buscarAlumnosPorCurso(Curso curso);
}
