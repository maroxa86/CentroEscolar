package org.centroescolar.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;

public class EditarAlumnoAccion extends Accion {

	public EditarAlumnoAccion() {
		super();
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inició del proceso para mostrar el formulario para modificar los datos de los alumnos");
		int id = Integer.parseInt(request.getParameter("id"));
		List<Curso> listaDeCursos = Curso.buscarTodosLosCursos();
		Alumno alumno = Alumno.BuscarAlumno(id);
		request.setAttribute("listaDeCursos", listaDeCursos);
		request.setAttribute("alumno", alumno);
		log.info("Finalización del proceso para mostrar el formulario para modificar los datos de los alumnos");
		return "editarAlumno.jsp";
	}

}
