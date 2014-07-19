package org.centroescolar.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;

public class MostrarAlumnosAccion extends Accion {

	public MostrarAlumnosAccion() {
		super();
	}

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inició del proceso para mostrar la información de los alumnos");
		
		List<Alumno> listaDeAlumnos = Alumno.buscarTodosLosAlumnos();
		List<Curso> listaDeCursos = Curso.buscarTodosLosCursos();
		
		request.setAttribute("listaDeAlumnos", listaDeAlumnos);
		request.setAttribute("listaDeCursos", listaDeCursos);
		
		log.info("Finalización del proceso para mostrar la información de los alumnos");
		
		return "mostrarAlumnos.jsp";
	}

}
