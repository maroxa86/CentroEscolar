package org.centroescolar.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.dao.impl.AlumnoImpl;

public class BorrarAlumnoAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inici� del proceso para borrar un alumno en el sistema");
		AlumnoImpl alumnoDAO = new AlumnoImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		Alumno alumno = new Alumno(id);
		alumnoDAO.borrarAlumno(alumno);
		log.info("Inici� del proceso para borrar un alumno en el sistema");
		return "MostrarAlumnos.do";
	}

}
