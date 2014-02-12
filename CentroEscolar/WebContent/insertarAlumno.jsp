<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>

<%
	String id = request.getParameter("id");	
	String nombre = request.getParameter("nombre");
	String primerApellido = request.getParameter("primerApellido");
	String segundoApellido = request.getParameter("segundoApellido");
	String curso = request.getParameter("curso");
	
	Connection conexion = null;
	Statement sentencia = null;
	
	int filas = 0;
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		conexion = DriverManager.getConnection(
								"jdbc:mysql://localhost/centroescolar",
								"root",
								"root");
		sentencia = conexion.createStatement();
		String consultaSQL = "insert into alum_alumno(id, nombre, primerApellido, segundoApellido, curso) values";
		consultaSQL += ("('"+ id +"','"+ nombre +"','"+ primerApellido +"','"+ segundoApellido +"','"+ curso +"')");
		
		filas = sentencia.executeUpdate(consultaSQL);
		
		response.sendRedirect("mostrarAlumnos.jsp");
	}
	catch(ClassNotFoundException e){
		System.out.println("Error en la carga del driver" + e.getMessage());
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