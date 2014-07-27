package org.centroescolar.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;
import org.centroescolar.aplicacion.servicios.ServicioAlumnos;

public class FiltrarCursoAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inició del proceso para filtrar los alumnos");
		
		ServicioAlumnos servicioAlumnos = (ServicioAlumnos)getBean("servicioAlumnos", request);
		
		List<Alumno> listaDeAlumnos = null;
		List<Curso> listaDeCursos = servicioAlumnos.buscarTodosLosCursos();
		
		if(request.getParameter("curso") == null || request.getParameter("curso").equals("seleccionar")){
			listaDeAlumnos = servicioAlumnos.buscarTodosLosAlumnos();
		}
		else{
			Curso curso = new Curso(Integer.parseInt(request.getParameter("curso")));
			listaDeAlumnos = servicioAlumnos.buscarAlumnosPorCurso(curso);
		}
		
		request.setAttribute("listaDeAlumnos", listaDeAlumnos);
		request.setAttribute("listaDeCursos", listaDeCursos);
		
		log.info("Finalización del proceso para filtrar los alumnos");
		
		return "mostrarAlumnos.jsp";
	}

}
