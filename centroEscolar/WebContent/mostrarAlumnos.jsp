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
	<form method="get" action="mostrarAlumnos.jsp">
		<select name="curso">
			<option value="seleccionar">seleccionar</option>
			<%
			List<String> cursos=null;
			cursos = Alumno.buscarTodosLosCursos();
			for(String curso : cursos) { %>
				<option value="<%=curso%>"><%=curso%></option>
			<% } %>
		</select>
		<input type="submit" value="Filtrar" id="filtrar">
	</form>
	<br/>
	<%
		List<Alumno> listaDeAlumnos = null;
		listaDeAlumnos = null;
		if (request.getParameter("curso")==null ||
			request.getParameter("curso").equals("seleccionar")) {
			listaDeAlumnos=Alumno.buscarTodosLosAlumnos();
		}
		else {
			listaDeAlumnos=Alumno.buscarAlumnosPorCurso(request.getParameter("curso"));
		}
		for(Alumno alumno : listaDeAlumnos){%>
			<%=alumno.getId()%>
			<%=alumno.getNombre()%>
			<%=alumno.getPrimerApellido()%>
			<%=alumno.getSegundoApellido()%>
			<%=alumno.getCurso()%>
			<a href="borrarAlumno.jsp?id=<%=alumno.getId()%>">Borrar</a>
			<a href="editarAlumno.jsp?id=<%=alumno.getId()%>">Editar</a>
			<br/>
		<%}
	%>
	<a href="altaAlumno.jsp">Añadir Nuevo Alumno</a>
</body>
</html>