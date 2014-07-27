package org.centroescolar.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.servicios.ServicioAlumnos;

public class BorrarAlumnoAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inició del proceso para borrar un alumno en el sistema");
		
		ServicioAlumnos servicioAlumnos = (ServicioAlumnos)getBean("servicioAlumnos", request);

		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Alumno alumno = new Alumno(id);
		
		servicioAlumnos.borrarAlumno(alumno);
		
		log.info("Inició del proceso para borrar un alumno en el sistema");
		
		return "MostrarAlumnos.do";
	}

}
