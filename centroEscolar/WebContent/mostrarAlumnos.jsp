<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.centroescolar.DataBaseHelper"%>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alumnos en el centro</title>
</head>
<body>
	<%
		ResultSet alumnos = null;
		try {
			String consultaSQL = "select id, nombre, primerApellido, segundoApellido, curso from alum_alumno";
			alumnos = DataBaseHelper.seleccionarRegistros(consultaSQL);
			while(alumnos.next()){%>
				<%=alumnos.getString("id")%>
				<%=alumnos.getString("nombre")%>
				<%=alumnos.getString("primerApellido")%>
				<%=alumnos.getString("segundoApellido")%>
				<%=alumnos.getString("curso")%>
				<br/>
			<%}
		}
		catch(SQLException e){
			System.out.println("Error accediendo a la base de datos: " + e.getMessage());
		}
		finally{
			if(alumnos != null){
				try{
					alumnos.close();
				}
				catch(SQLException e){
					System.out.println("Error cerrando la sentencia: " + e.getMessage());
				}
			}
		}
	%>
	<a href="altaAlumno.jsp">Añadir Nuevo Alumno</a>
</body>
</html>