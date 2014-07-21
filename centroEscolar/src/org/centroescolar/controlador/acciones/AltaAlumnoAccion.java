package org.centroescolar.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.aplicacion.bo.Curso;
import org.centroescolar.aplicacion.dao.CursoDAO;
import org.centroescolar.aplicacion.factory.DAOAbstractFactory;
import org.centroescolar.aplicacion.factory.DAOFactory;

public class AltaAlumnoAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inici� del proceso para mostrar el formulario para dar de alta a los alumnos");
		
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		CursoDAO cursoDAO = factoria.getCursoDAO();
		
		List<Curso> listaDeCursos = cursoDAO.buscarTodos();
		
		request.setAttribute("listaDeCursos", listaDeCursos);
		
		log.info("Finalizaci�n del proceso para mostrar el formulario para dar de alta a los alumnos");
		
		return "altaAlumno.jsp";
	}

}
