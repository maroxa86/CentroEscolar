package org.centroescolar.aplicacion.servicios.impl;

import java.util.List;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;
import org.centroescolar.aplicacion.dao.AlumnoDAO;
import org.centroescolar.aplicacion.dao.CursoDAO;
import org.centroescolar.aplicacion.factory.DAOAbstractFactory;
import org.centroescolar.aplicacion.factory.DAOFactory;
import org.centroescolar.aplicacion.servicios.ServicioAlumnos;

public class ServicioAlumnosImpl implements ServicioAlumnos {

	private AlumnoDAO alumnoDAO = null;
	private CursoDAO cursoDAO = null;
	
	public ServicioAlumnosImpl(){
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		alumnoDAO = factoria.getAlumnoDAO();
		cursoDAO = factoria.getCursoDAO();
	}
	
	@Override
	public void insertarAlumno(Alumno alumno) {
		alumnoDAO.insertarAlumno(alumno);
	}

	@Override
	public void borrarAlumno(Alumno alumno) {
		alumnoDAO.borrarAlumno(alumno);
	}

	@Override
	public List<Alumno> buscarTodosLosAlumnos() {
		return alumnoDAO.buscarTodos();
	}

	@Override
	public List<Curso> buscarTodosLosCursos() {
		return cursoDAO.buscarTodos();
	}

	@Override
	public Alumno BuscarAlumno(int id) {
		return alumnoDAO.BuscarAlumno(id);
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		alumnoDAO.modificarAlumno(alumno);

	}

	@Override
	public List<Alumno> buscarAlumnosPorCurso(Curso curso) {
		return alumnoDAO.buscarAlumnosPorCurso(curso);
	}

}
