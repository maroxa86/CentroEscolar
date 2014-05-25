<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List;" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Nuevo Alumno</title>
</head>
<body>
	<form method="post" id="formularioAltaAlumno" name="formularioAltaAlumno" action="InsertarAlumno.do">
		<fieldset>
			<legend>Formulario para anadir un nuevo alumno</legend>
			<p>
				<label for="id">Identificador</label>
				<input type="text" id="id" name="id" />
			</p>
			<p>
				<label for="nombre">Nombre</label>
				<input type="text" id="nombre" name="nombre" />
			</p>
			<p>
				<label for="primerApellido">Primer Apellido</label>
				<input type="text" id="primerApellido" name="primerApellido" />
			</p>
			<p>
				<label for="segundoApellido">Segundo Apellido</label>
				<input type="text" id="segundoApellido" name="segundoApellido" />
			</p>
			<p>
				<label for="curso">Curso</label>
				<select name="curso">
					<option value="seleccionar">seleccionar</option>
					<c:forEach var="curso" items="${listaDeCursos}">
						<option value="${curso}">${curso}</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<input type="submit" id="altaAlumno" name="altaAlumno" value="Nuevo Alumno"/>
			</p>
		</fieldset>
	</form>
</body>
</html>