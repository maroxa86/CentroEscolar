package org.centroescolar.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.centroescolar.controlador.acciones.Accion;

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
		Accion accion = null;
		String url = request.getServletPath();
		accion = Accion.getAccion(url.substring(1,url.length()-3));
		despachador = request.getRequestDispatcher(accion.ejecutar(request, response));
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
