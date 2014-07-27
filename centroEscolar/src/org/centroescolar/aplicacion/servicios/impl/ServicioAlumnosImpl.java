package org.centroescolar.aplicacion.servicios.impl;

import java.util.List;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;
import org.centroescolar.aplicacion.dao.AlumnoDAO;
import org.centroescolar.aplicacion.dao.CursoDAO;
import org.centroescolar.aplicacion.servicios.ServicioAlumnos;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServicioAlumnosImpl implements ServicioAlumnos {

	private AlumnoDAO alumnoDAO = null;
	private CursoDAO cursoDAO = null;
	
	@SuppressWarnings("resource")
	public ServicioAlumnosImpl(){
		ClassPathXmlApplicationContext factoria = new ClassPathXmlApplicationContext("contextoAplicacion.xml"); 
		alumnoDAO = (AlumnoDAO) factoria.getBean("alumnoDAO");
		cursoDAO = (CursoDAO) factoria.getBean("cursoDAO");
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
