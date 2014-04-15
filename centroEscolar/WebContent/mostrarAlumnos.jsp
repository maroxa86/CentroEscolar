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
	<select name="curso">
		<option value="seleccionar">seleccionar</option>
		<%
		List<String> cursos=null;
		Alumno alumno = new Alumno();
		cursos = alumno.buscarTodosLosCursos();
		for(String curso : cursos) { %>
			<option value="<%=curso%>"><%=curso%></option>
		<% } %>
	</select>
	<br/>
	<%
		List<Alumno> listaDeAlumnos = null;
		listaDeAlumnos = alumno.buscarTodosLosAlumnos();
		for(Alumno alum : listaDeAlumnos){%>
			<%=alum.getId()%>
			<%=alum.getNombre()%>
			<%=alum.getPrimerApellido()%>
			<%=alum.getSegundoApellido()%>
			<%=alum.getCurso()%>
			<br/>
		<%}
	%>
	<a href="altaAlumno.jsp">Añadir Nuevo Alumno</a>
</body>
</html>