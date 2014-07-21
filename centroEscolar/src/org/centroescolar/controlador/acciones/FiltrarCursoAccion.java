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

public class FiltrarCursoAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inició del proceso para filtrar los alumnos");
		
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		AlumnoDAO alumnoDAO = factoria.getAlumnoDAO();
		CursoDAO cursoDAO = factoria.getCursoDAO();
		
		List<Alumno> listaDeAlumnos = null;
		List<Curso> listaDeCursos = cursoDAO.buscarTodos();
		
		if(request.getParameter("curso") == null || request.getParameter("curso").equals("seleccionar")){
			listaDeAlumnos = alumnoDAO.buscarTodos();
		}
		else{
			Curso curso = new Curso(Integer.parseInt(request.getParameter("curso")));
			listaDeAlumnos = alumnoDAO.buscarAlumnosPorCurso(curso);
		}
		
		request.setAttribute("listaDeAlumnos", listaDeAlumnos);
		request.setAttribute("listaDeCursos", listaDeCursos);
		
		log.info("Finalización del proceso para filtrar los alumnos");
		
		return "mostrarAlumnos.jsp";
	}

}
