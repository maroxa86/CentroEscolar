package org.centroescolar.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.Alumno;

public class EditarAlumnoAccion extends Accion {

	public EditarAlumnoAccion() {
		super();
	}

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inició del proceso para mostrar el formulario para modificar los datos de los alumnos");
		String id = request.getParameter("id");
		List<String> listaDeCursos = Alumno.buscarTodosLosCursos();
		Alumno alumno = Alumno.BuscarAlumno(id);
		request.setAttribute("listaDeCursos", listaDeCursos);
		request.setAttribute("alumno", alumno);
		log.info("Finalización del proceso para mostrar el formulario para modificar los datos de los alumnos");
		return "editarAlumno.jsp";
	}

}
