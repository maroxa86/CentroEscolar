package org.centroescolar.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.Alumno;

public class InsertarAlumnoAccion extends Accion {
	
	public InsertarAlumnoAccion(){
		super();
	}

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inició del proceso para insertar un nuevo alumno en el sistema");
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String primerApellido = request.getParameter("primerApellido");
		String segundoApellido = request.getParameter("segundoApellido");
		String curso = request.getParameter("curso");

		Alumno alumno = new Alumno(id, nombre, primerApellido, segundoApellido, curso);
		alumno.insertarAlumno();

		log.info("Finalización del proceso para insertar un nuevo alumno en el sistema");
		return "MostrarAlumnos.do";
	}

}
