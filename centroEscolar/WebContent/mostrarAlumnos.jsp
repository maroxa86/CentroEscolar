<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List;" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alumnos en el centro</title>
</head>
<body>
	<form method="get" action="FiltrarCurso.do">
		<select name="curso">
			<option value="seleccionar" selected="selected">seleccionar</option>
			<c:forEach var="curso" items="${listaDeCursos}">
				<option value="${curso.id}">${curso.curso}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Filtrar" id="filtrar">
	</form>
	<br/>
	<c:forEach var="alumno" items="${listaDeAlumnos}">
		${alumno.id} ${alumno.nombre} ${alumno.primerApellido} ${alumno.segundoApellido} ${alumno.curso.curso}
		<a href="BorrarAlumno.do?id=${alumno.id}">Borrar</a>
		<a href="EditarAlumno.do?id=${alumno.id}">Editar</a>
		<br/>
	</c:forEach>
	<a href="AltaAlumno.do">Añadir Nuevo Alumno</a>
</body>
</html>