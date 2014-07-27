package org.centroescolar.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;
import org.centroescolar.aplicacion.servicios.ServicioAlumnos;

public class MostrarAlumnosAccion extends Accion {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inici� del proceso para mostrar la informaci�n de los alumnos");
		
		ServicioAlumnos servicioAlumnos = (ServicioAlumnos)getBean("servicioAlumnos", request);
		
		List<Alumno> listaDeAlumnos = servicioAlumnos.buscarTodosLosAlumnos();
		List<Curso> listaDeCursos = servicioAlumnos.buscarTodosLosCursos();
		
		request.setAttribute("listaDeAlumnos", listaDeAlumnos);
		request.setAttribute("listaDeCursos", listaDeCursos);
		
		log.info("Finalizaci�n del proceso para mostrar la informaci�n de los alumnos");
		
		return "mostrarAlumnos.jsp";
	}

}
