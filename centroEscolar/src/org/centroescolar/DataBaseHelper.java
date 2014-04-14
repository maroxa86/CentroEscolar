package org.centroescolar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseHelper {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/centroEscolar";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "root";
	private static final String DRIVERERROR = "Error al cargar el driver";
	private static final String DBERROR = "Error accediendo a la base de datos";

	public static ResultSet seleccionarRegistros(String consultaSQL) {

		Connection conexion = null;
		Statement sentencia = null;
		ResultSet alumnos = null;

		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
			sentencia = conexion.createStatement();
			alumnos = sentencia.executeQuery(consultaSQL);
		} catch (ClassNotFoundException e) {
			System.out.println(DRIVERERROR + e.getMessage());
		} catch (SQLException e) {
			System.out.println(DBERROR + e.getMessage());
		}

		return alumnos;
	}

	public void modificarRegistro(String consultaSQL) {
		Connection conexion = null;
		Statement sentencia = null;

		try {

			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
			sentencia = conexion.createStatement();
			sentencia.executeUpdate(consultaSQL);

		} catch (ClassNotFoundException e) {
			System.out.println(DRIVERERROR + e.getMessage());
		} catch (SQLException e) {
			System.out.println(DBERROR + e.getMessage());
		} finally {
			if (sentencia != null) {
				try {
					sentencia.close();
				} catch (SQLException e) {
					System.out.println("Error cerrando la sentencia: "
							+ e.getMessage());
				}
			}

			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					System.out.println("Error cerrando la conexion: "
							+ e.getMessage());
				}
			}
		}
	}

}
