package org.centroescolar.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;

public class FiltrarCursoAccion extends Accion {

	public FiltrarCursoAccion() {
		super();
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inició del proceso para filtrar los alumnos");
		List<Alumno> listaDeAlumnos = null;
		List<Curso> listaDeCursos = Curso.buscarTodosLosCursos();
		if(request.getParameter("curso") == null || request.getParameter("curso").equals("seleccionar")){
			listaDeAlumnos = Alumno.buscarTodosLosAlumnos();
		}
		else{
			listaDeAlumnos = Alumno.buscarAlumnosPorCurso(request.getParameter("curso"));
		}
		request.setAttribute("listaDeAlumnos", listaDeAlumnos);
		request.setAttribute("listaDeCursos", listaDeCursos);
		log.info("Finalización del proceso para filtrar los alumnos");
		return "mostrarAlumnos.jsp";
	}

}
