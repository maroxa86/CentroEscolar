package org.centroescolar.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;
import org.centroescolar.aplicacion.servicios.ServicioAlumnos;

public class EditarAlumnoAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inició del proceso para mostrar el formulario para modificar los datos de los alumnos");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		ServicioAlumnos servicioAlumnos = (ServicioAlumnos)getBean("servicioAlumnos", request);

		
		List<Curso> listaDeCursos = servicioAlumnos.buscarTodosLosCursos();
		
		Alumno alumno = servicioAlumnos.BuscarAlumno(id);
		
		request.setAttribute("listaDeCursos", listaDeCursos);
		request.setAttribute("alumno", alumno);
		
		log.info("Finalización del proceso para mostrar el formulario para modificar los datos de los alumnos");
		
		return "editarAlumno.jsp";
	}

}
