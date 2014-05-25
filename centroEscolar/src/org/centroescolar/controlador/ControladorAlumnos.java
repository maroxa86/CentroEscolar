package org.centroescolar.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.centroescolar.Alumno;

/**
 * Servlet implementation class ControladorAlumnos
 */
public class ControladorAlumnos extends HttpServlet {
	private static final long	serialVersionUID	= 1L;
	private static final Logger log = Logger.getLogger(ControladorAlumnos.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorAlumnos() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void processar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("ServletPath: " + request.getServletPath());
		RequestDispatcher despachador = null;
		if (request.getServletPath().equals("/MostrarAlumnos.do")) {
			log.info("Inició del proceso para mostrar la información de los alumnos");
			List<Alumno> listaDeAlumnos = Alumno.buscarTodosLosAlumnos();
			List<String> listaDeCursos = Alumno.buscarTodosLosCursos();
			request.setAttribute("listaDeAlumnos", listaDeAlumnos);
			request.setAttribute("listaDeCursos", listaDeCursos);
			despachador = request.getRequestDispatcher("mostrarAlumnos.jsp");
			log.info("Finalización del proceso para mostrar la información de los alumnos");
		} else {
			if (request.getServletPath().equals("/AltaAlumno.do")) {
				log.info("Inició del proceso para mostrar el formulario para dar de alta a los alumnos");
				List<String> listaDeCursos = Alumno.buscarTodosLosCursos();
				request.setAttribute("listaDeCursos", listaDeCursos);
				despachador = request.getRequestDispatcher("altaAlumno.jsp");
				log.info("Finalización del proceso para mostrar el formulario para dar de alta a los alumnos");
			} else {
				if (request.getServletPath().equals("/InsertarAlumno.do")) {
					log.info("Inició del proceso para insertar un nuevo alumno en el sistema");
					String id = request.getParameter("id");
					String nombre = request.getParameter("nombre");
					String primerApellido = request.getParameter("primerApellido");
					String segundoApellido = request.getParameter("segundoApellido");
					String curso = request.getParameter("curso");

					Alumno alumno = new Alumno(id, nombre, primerApellido, segundoApellido, curso);
					alumno.insertarAlumno();

					despachador = request.getRequestDispatcher("MostrarAlumnos.do");
					log.info("Finalixsción del proceso para insertar un nuevo alumno en el sistema");
				} else {
					if (request.getServletPath().equals("/BorrarAlumno.do")) {
						log.info("Inició del proceso para borrar un alumno en el sistema");
						String id = request.getParameter("id");
						Alumno alumno = new Alumno(id);
						alumno.borrarAlumno();

						despachador = request.getRequestDispatcher("MostrarAlumnos.do");
						log.info("Inició del proceso para borrar un alumno en el sistema");
					} else {
						if (request.getServletPath().equals("/EditarAlumno.do")) {
							log.info("Inició del proceso para mostrar el formulario para modificar los datos de los alumnos");
							String id = request.getParameter("id");
							List<String> listaDeCursos = Alumno.buscarTodosLosCursos();
							Alumno alumno = Alumno.BuscarAlumno(id);
							request.setAttribute("listaDeCursos", listaDeCursos);
							request.setAttribute("alumno", alumno);
							despachador = request.getRequestDispatcher("editarAlumno.jsp");
							log.info("Finalización del proceso para mostrar el formulario para modificar los datos de los alumnos");
						} else {
							if (request.getServletPath().equals("/ModificarAlumno.do")) {
								log.info("Inició del proceso para modificar los datos de un alumno");
								String id = request.getParameter("id");
								String nombre = request.getParameter("nombre");
								String primerApellido = request.getParameter("primerApellido");
								String segundoApellido = request.getParameter("segundoApellido");
								String curso = request.getParameter("curso");

								Alumno alumno = new Alumno(id, nombre, primerApellido, segundoApellido, curso);
								alumno.modificarAlumno();

								despachador = request.getRequestDispatcher("MostrarAlumnos.do");
								log.info("Inició del proceso para modificar los datos de un alumno");
							}
							else{
								if (request.getServletPath().equals("/FiltrarCurso.do")) {
									log.info("Inició del proceso para filtrar los alumnos");
									List<Alumno> listaDeAlumnos = null;
									List<String> listaDeCursos = Alumno.buscarTodosLosCursos();
									if(request.getParameter("curso") == null || request.getParameter("curso").equals("seleccionar")){
										listaDeAlumnos = Alumno.buscarTodosLosAlumnos();
									}
									else{
										listaDeAlumnos = Alumno.buscarAlumnosPorCurso(request.getParameter("curso"));
									}
									request.setAttribute("listaDeAlumnos", listaDeAlumnos);
									request.setAttribute("listaDeCursos", listaDeCursos);
									despachador = request.getRequestDispatcher("mostrarAlumnos.jsp");
									log.info("Finalización del proceso para filtrar los alumnos");
								}
							}
						}
					}
				}
			}
		}
		despachador.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processar(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processar(request, response);
	}
}
