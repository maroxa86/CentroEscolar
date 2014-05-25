package org.centroescolar.controlador.acciones;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.Alumno;
import org.centroescolar.controlador.acciones.Accion;


public class ModificarAlumnoAccion extends Accion {

	public ModificarAlumnoAccion() {
		super();
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inici� del proceso para modificar los datos de un alumno");
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String primerApellido = request.getParameter("primerApellido");
		String segundoApellido = request.getParameter("segundoApellido");
		String curso = request.getParameter("curso");

		Alumno alumno = new Alumno(id, nombre, primerApellido, segundoApellido, curso);
		alumno.modificarAlumno();

		log.info("Inici� del proceso para modificar los datos de un alumno");
		return "MostrarAlumnos.do";
	}

}
