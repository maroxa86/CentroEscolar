package org.centroescolar.aplicacion.servicios.impl;

import java.util.List;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;
import org.centroescolar.aplicacion.dao.AlumnoDAO;
import org.centroescolar.aplicacion.dao.CursoDAO;
import org.centroescolar.aplicacion.servicios.ServicioAlumnos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="servicioAlumnos")
public class ServicioAlumnosImpl implements ServicioAlumnos {

	private AlumnoDAO alumnoDAO = null;
	private CursoDAO cursoDAO = null;
	
	@Override
	@Transactional
	public void insertarAlumno(Alumno alumno) {
		alumnoDAO.insertar(alumno);
	}

	@Override
	@Transactional
	public void borrarAlumno(Alumno alumno) {
		alumnoDAO.borrar(alumno);
	}

	@Override
	@Transactional
	public List<Alumno> buscarTodosLosAlumnos() {
		return alumnoDAO.buscarTodos();
	}

	@Override
	@Transactional
	public List<Curso> buscarTodosLosCursos() {
		return cursoDAO.buscarTodos();
	}

	@Override
	@Transactional
	public Alumno BuscarAlumno(int id) {
		return alumnoDAO.BuscarAlumno(id);
	}

	@Override
	@Transactional
	public void modificarAlumno(Alumno alumno) {
		alumnoDAO.modificar(alumno);

	}

	@Override
	@Transactional
	public List<Alumno> buscarAlumnosPorCurso(Curso curso) {
		return alumnoDAO.buscarAlumnosPorCurso(curso);
	}

	@Override
	@Autowired
	public void setAlumnoDAO(AlumnoDAO alumnoDAO) {
		this.alumnoDAO = alumnoDAO;
		
	}

	@Override
	public AlumnoDAO getAlumnoDAO() {
		return alumnoDAO;
	}

	@Override
	@Autowired
	public void setCursoDAO(CursoDAO cursoDAO) {
		this.cursoDAO = cursoDAO;
		
	}

	@Override
	public CursoDAO getsetCursoDAO() {
		return cursoDAO;
	}

}
