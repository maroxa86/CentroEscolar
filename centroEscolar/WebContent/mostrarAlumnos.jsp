<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.centroescolar.Alumno"%>
<%@ page import="java.util.List;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alumnos en el centro</title>
</head>
<body>
	<form method="get" action="FiltrarCurso.do">
		<select name="curso">
			<option value="seleccionar">seleccionar</option>
			<%
			List<String> cursos=null;
			cursos = (List<String>) request.getAttribute("listaDeCursos");
			for(String curso : cursos) { 
				if(curso.equals(request.getParameter("curso"))){%>
				<option value="<%=curso%>" selected="selected"><%=curso%></option>
			<% }
				else{%>
				<option value="<%=curso%>"><%=curso%></option>
			<% }
			}%>
		</select>
		<input type="submit" value="Filtrar" id="filtrar">
	</form>
	<br/>
	<%
		List<Alumno> listaDeAlumnos = null;
		listaDeAlumnos = null;
		listaDeAlumnos=(List<Alumno>) request.getAttribute("listaDeAlumnos");
		for(Alumno alumno : listaDeAlumnos){%>
			<%=alumno.getId()%>
			<%=alumno.getNombre()%>
			<%=alumno.getPrimerApellido()%>
			<%=alumno.getSegundoApellido()%>
			<%=alumno.getCurso()%>
			<a href="BorrarAlumno.do?id=<%=alumno.getId()%>">Borrar</a>
			<a href="EditarAlumno.do?id=<%=alumno.getId()%>">Editar</a>
			<br/>
		<%}%>
	<a href="AltaAlumno.do">Añadir Nuevo Alumno</a>
</body>
</html>