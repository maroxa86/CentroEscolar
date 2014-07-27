package org.centroescolar.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.aplicacion.bo.Curso;
import org.centroescolar.aplicacion.servicios.ServicioAlumnos;

public class AltaAlumnoAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inició del proceso para mostrar el formulario para dar de alta a los alumnos");
		
		ServicioAlumnos servicioAlumnos = (ServicioAlumnos)getBean("servicioAlumnos", request);
		
		List<Curso> listaDeCursos = servicioAlumnos.buscarTodosLosCursos();
		
		request.setAttribute("listaDeCursos", listaDeCursos);
		
		log.info("Finalización del proceso para mostrar el formulario para dar de alta a los alumnos");
		
		return "altaAlumno.jsp";
	}

}
