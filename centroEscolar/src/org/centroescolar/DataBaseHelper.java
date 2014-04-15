package org.centroescolar;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper<T> {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/centroEscolar";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "root";
	private static final String DRIVERERROR = "Error al cargar el driver";
	private static final String DBERROR = "Error accediendo a la base de datos";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> seleccionarRegistros(String consultaSQL, Class clase) {

		Connection conexion = null;
		Statement sentencia = null;
		ResultSet filas = null;
		List<T> listaDeObjetos=new ArrayList<T>();
		
		try {
			
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
			sentencia = conexion.createStatement();
			filas = sentencia.executeQuery(consultaSQL);
			
			while (filas.next()) {
				
				T objeto=(T) Class.forName(clase.getName()).newInstance();
				Method[] metodos=objeto.getClass().getDeclaredMethods();
				
				for (int i=0;i<metodos.length;i++) {
					
					if (metodos[i].getName().startsWith("set") ) {
						metodos[i].invoke(objeto,
						filas.getString(metodos[i].getName().substring(3)));
					}
					
					if (objeto.getClass().getName().equals("java.lang.String")) {
						objeto=(T)filas.getString(1);
					}
				}
				
				listaDeObjetos.add(objeto);
			}
		} catch (Exception e) {
			System.out.println("Error al seleccionar registros" + e.getMessage());
		}finally {
			
			if (filas != null) {
				try {
					filas.close();
				} catch (SQLException e) {
					System.out.println("Error al cerrar el ResultSet: " + e.getMessage());
				}
			}
			
			if (sentencia != null) {
				try {
					sentencia.close();
				} catch (SQLException e) {
					System.out.println("Error al cerrar la sentencia: " + e.getMessage());
				}
			}
			
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					System.out.println("Error al cerrar la conexion: " + e.getMessage());
				}
			}
			
		}
		return listaDeObjetos;
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
					System.out.println("Error cerrando la sentencia: " + e.getMessage());
				}
			}

			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					System.out.println("Error cerrando la conexion: " + e.getMessage());
				}
			}
		}
	}

}
