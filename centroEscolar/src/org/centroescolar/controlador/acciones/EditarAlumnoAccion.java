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

public class EditarAlumnoAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inició del proceso para mostrar el formulario para modificar los datos de los alumnos");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		AlumnoDAO alumnoDAO = factoria.getAlumnoDAO();
		CursoDAO cursoDAO = factoria.getCursoDAO();
		
		List<Curso> listaDeCursos = cursoDAO.buscarTodos();
		
		Alumno alumno = alumnoDAO.BuscarAlumno(id);
		
		request.setAttribute("listaDeCursos", listaDeCursos);
		request.setAttribute("alumno", alumno);
		
		log.info("Finalización del proceso para mostrar el formulario para modificar los datos de los alumnos");
		
		return "editarAlumno.jsp";
	}

}
