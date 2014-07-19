package org.centroescolar.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;
import org.centroescolar.aplicacion.dao.impl.AlumnoImpl;
import org.centroescolar.aplicacion.dao.impl.CursoImpl;

public class MostrarAlumnosAccion extends Accion {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inici� del proceso para mostrar la informaci�n de los alumnos");
		
		AlumnoImpl alumnoDAO = new AlumnoImpl();
		CursoImpl cursoDAO = new CursoImpl();
		List<Alumno> listaDeAlumnos = alumnoDAO.buscarTodos();
		List<Curso> listaDeCursos = cursoDAO.buscarTodos();
		
		request.setAttribute("listaDeAlumnos", listaDeAlumnos);
		request.setAttribute("listaDeCursos", listaDeCursos);
		
		log.info("Finalizaci�n del proceso para mostrar la informaci�n de los alumnos");
		
		return "mostrarAlumnos.jsp";
	}

}
