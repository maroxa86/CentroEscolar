package org.centroescolar.controlador.acciones;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;
import org.centroescolar.aplicacion.dao.impl.AlumnoImpl;


public class ModificarAlumnoAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inició del proceso para modificar los datos de un alumno");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String primerApellido = request.getParameter("primerApellido");
		String segundoApellido = request.getParameter("segundoApellido");
		Curso curso = new Curso(Integer.parseInt(request.getParameter("curso")));

		Alumno alumno = new Alumno(id, nombre, primerApellido, segundoApellido, curso);
		
		AlumnoImpl alumnoDAO = new AlumnoImpl();
		
		alumnoDAO.modificarAlumno(alumno);

		log.info("Inició del proceso para modificar los datos de un alumno");
		
		return "MostrarAlumnos.do";
	}

}
