package org.centroescolar.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.dao.AlumnoDAO;
import org.centroescolar.aplicacion.factory.DAOAbstractFactory;
import org.centroescolar.aplicacion.factory.DAOFactory;

public class BorrarAlumnoAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inició del proceso para borrar un alumno en el sistema");
		
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		AlumnoDAO alumnoDAO = factoria.getAlumnoDAO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Alumno alumno = new Alumno(id);
		
		alumnoDAO.borrarAlumno(alumno);
		
		log.info("Inició del proceso para borrar un alumno en el sistema");
		
		return "MostrarAlumnos.do";
	}

}
