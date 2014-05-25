package org.centroescolar.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.Alumno;

public class MostrarAlumnosAccion extends Accion {

	public MostrarAlumnosAccion() {
		super();
	}

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inici� del proceso para mostrar la informaci�n de los alumnos");
		List<Alumno> listaDeAlumnos = Alumno.buscarTodosLosAlumnos();
		List<String> listaDeCursos = Alumno.buscarTodosLosCursos();
		request.setAttribute("listaDeAlumnos", listaDeAlumnos);
		request.setAttribute("listaDeCursos", listaDeCursos);
		log.info("Finalizaci�n del proceso para mostrar la informaci�n de los alumnos");
		return "mostrarAlumnos.jsp";
	}

}
