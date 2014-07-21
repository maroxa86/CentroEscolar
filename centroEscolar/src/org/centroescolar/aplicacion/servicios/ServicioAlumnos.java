package org.centroescolar.aplicacion.servicios;

import java.util.List;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;

public interface ServicioAlumnos {
	public void insertarAlumno(Alumno alumno);
	public void borrarAlumno(Alumno alumno);
	public List<Alumno> buscarTodosLosAlumnos();
	public List<Curso> buscarTodosLosCursos();
	public Alumno BuscarAlumno(int id);
	public void modificarAlumno(Alumno alumno);
	public List<Alumno> buscarAlumnosPorCurso(Curso curso);
}
