package org.centroescolar.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;
import org.centroescolar.aplicacion.dao.AlumnoDAO;
import org.centroescolar.aplicacion.dao.CursoDAO;
import org.centroescolar.aplicacion.factory.DAOAbstractFactory;
import org.centroescolar.aplicacion.factory.DAOFactory;

public class MostrarAlumnosAccion extends Accion {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inició del proceso para mostrar la información de los alumnos");
		
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		AlumnoDAO alumnoDAO = factoria.getAlumnoDAO();
		CursoDAO cursoDAO = factoria.getCursoDAO();
		
		List<Alumno> listaDeAlumnos = alumnoDAO.buscarTodos();
		List<Curso> listaDeCursos = cursoDAO.buscarTodos();
		
		request.setAttribute("listaDeAlumnos", listaDeAlumnos);
		request.setAttribute("listaDeCursos", listaDeCursos);
		
		log.info("Finalización del proceso para mostrar la información de los alumnos");
		
		return "mostrarAlumnos.jsp";
	}

}
