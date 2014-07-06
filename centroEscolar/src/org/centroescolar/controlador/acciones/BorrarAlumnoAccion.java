package org.centroescolar.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.aplicacion.bo.Alumno;

public class BorrarAlumnoAccion extends Accion {

	public BorrarAlumnoAccion() {
		super();
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inició del proceso para borrar un alumno en el sistema");
		int id = Integer.parseInt(request.getParameter("id"));
		Alumno alumno = new Alumno(id);
		alumno.borrarAlumno();
		log.info("Inició del proceso para borrar un alumno en el sistema");
		return "MostrarAlumnos.do";
	}

}
