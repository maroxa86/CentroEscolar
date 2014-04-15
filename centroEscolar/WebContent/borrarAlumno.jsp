<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="org.centroescolar.Alumno"%>
<%
	String id = request.getParameter("id");
	Alumno alumno = new Alumno(id);
	alumno.borrar();
	response.sendRedirect("mostrarAlumnos.jsp");
%>