package org.centroescolar.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;
import org.centroescolar.aplicacion.dao.AlumnoDAO;
import org.centroescolar.aplicacion.factory.DAOAbstractFactory;
import org.centroescolar.aplicacion.factory.DAOFactory;

public class InsertarAlumnoAccion extends Accion {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		log.info("Inici� del proceso para insertar un nuevo alumno en el sistema");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String primerApellido = request.getParameter("primerApellido");
		String segundoApellido = request.getParameter("segundoApellido");
		Curso curso = new Curso(Integer.parseInt(request.getParameter("curso")));

		Alumno alumno = new Alumno(id, nombre, primerApellido, segundoApellido, curso);
		
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		AlumnoDAO alumnoDAO = factoria.getAlumnoDAO();
		
		alumnoDAO.insertarAlumno(alumno);

		log.info("Finalizaci�n del proceso para insertar un nuevo alumno en el sistema");
		
		return "MostrarAlumnos.do";
	}

}
