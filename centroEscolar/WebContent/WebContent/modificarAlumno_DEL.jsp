<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.centroescolar.Alumno"%>
<% 
	String id = request.getParameter("id");
	String nombre = request.getParameter("nombre");
	String primerApellido = request.getParameter("primerApellido");
	String segundoApellido = request.getParameter("segundoApellido");
	String curso = request.getParameter("curso");
	
	Alumno alumno = new Alumno(id, nombre, primerApellido, segundoApellido, curso);
	alumno.modificarAlumno();
	
	response.sendRedirect("mostrarAlumnos.jsp");
%>