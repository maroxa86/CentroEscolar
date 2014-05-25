<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.centroescolar.Alumno"%>
<%@ page import="java.util.List;" %>
<%
	Alumno alumno = (Alumno) request.getAttribute("alumno");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Alumno</title>
</head>
<body>
	<form method="post" id="formularioEditarAlumno" name="formularioEditarAlumno" action="ModificarAlumno.do">
		<fieldset>
			<legend>Formulario para modificar un alumno</legend>
			<p>
				<label for="id">Identificador</label>
				<input type="text" id="id" name="id" value="<%=alumno.getId()%>"/>
			</p>
			<p>
				<label for="nombre">Nombre</label>
				<input type="text" id="nombre" name="nombre" value="<%=alumno.getNombre()%>"/>
			</p>
			<p>
				<label for="primerApellido">Primer Apellido</label>
				<input type="text" id="primerApellido" name="primerApellido" value="<%=alumno.getPrimerApellido()%>"/>
			</p>
			<p>
				<label for="segundoApellido">Segundo Apellido</label>
				<input type="text" id="segundoApellido" name="segundoApellido" value="<%=alumno.getSegundoApellido()%>"/>
			</p>
			<p>
				<label for="curso">Curso</label>
				<select name="curso">
					<option value="seleccionar">seleccionar</option>
					<%
					List<String> cursos=null;
					cursos = (List<String>) request.getAttribute("listaDeCursos");
					for(String curso : cursos) { 
						if(curso.equals(alumno.getCurso())){%>
						<option value="<%=curso%>" selected="selected"><%=curso%></option>
					<% }
						else{%>
							<option value="<%=curso%>"><%=curso%></option>
						<%}
					}%>
				</select>
			</p>
			<p>
				<input type="submit" id="altaAlumno" name="altaAlumno" value="Modificar Alumno"/>
			</p>
		</fieldset>
	</form>
</body>
</html>