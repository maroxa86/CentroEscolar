<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
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
		Connection conexion=null;
		Statement sentencia=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/centroEscolar","root","root");
			sentencia = conexion.createStatement();
			String consultaSQL = "select id, nombre, primerApellido, segundoApellido, curso from alum_alumno";
			rs=sentencia.executeQuery(consultaSQL);
			while(rs.next()){%>
				<%=rs.getString("id")%>
				<%=rs.getString("nombre")%>
				<%=rs.getString("primerApellido")%>
				<%=rs.getString("segundoApellido")%>
				<%=rs.getString("curso")%>
				<br/>
			<%}
		}
		catch(ClassNotFoundException e){
			System.out.println("Error al cargar el driver" + e.getMessage());
		}
		catch(SQLException e){
			System.out.println("Error accediendo a la base de datos" + e.getMessage());
		}
		finally{
			if(sentencia != null){
				try{
					sentencia.close();
				}
				catch(SQLException e){
					System.out.println("Error cerrando la sentencia" + e.getMessage());
				}
			}
			
			if(conexion != null){
				try{
					conexion.close();
				}
				catch(SQLException e){
					System.out.println("Error cerrando la conexion" + e.getMessage());
				}
			}
		}
	%>
	<a href="altaAlumno.jsp">Añadir Nuevo Alumno</a>
</body>
</html>