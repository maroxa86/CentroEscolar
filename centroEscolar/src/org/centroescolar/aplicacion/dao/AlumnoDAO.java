package org.centroescolar.aplicacion.dao;

import java.util.List;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;

public interface AlumnoDAO {
	public void insertarAlumno(Alumno alumno);
	public void borrarAlumno(Alumno alumno);
	public Alumno BuscarAlumno(int id);
	public void modificarAlumno(Alumno alumno);
	public List<Alumno> buscarAlumnosPorCurso(Curso curso);
}
