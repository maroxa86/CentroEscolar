<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.centroEscolar.DataBaseHelper"%>
<%
	String id = request.getParameter("id");
	String nombre = request.getParameter("nombre");
	String primerApellido = request.getParameter("primerApellido");
	String segundoApellido = request.getParameter("segundoApellido");
	String curso = request.getParameter("curso");
	
	String consultaSQL = "insert into alum_alumno (id, nombre, primerApellido, segundoApellido, curso) values";
	consultaSQL += "('"+id+"','"+nombre+"','"+primerApellido+"','"+segundoApellido+"','"+curso+"')";
	DataBaseHelper datos = new DataBaseHelper();
	datos.modificarRegistro(consultaSQL);
	response.sendRedirect("mostrarAlumnos.jsp");
%>