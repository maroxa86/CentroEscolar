package org.centroescolar;

import java.util.List;

import org.apache.log4j.Logger;

public class Alumno {

	private static final Logger log = Logger.getLogger(Alumno.class);
	private String id = null;
	private String nombre = null;
	private String primerApellido = null;
	private String segundoApellido = null;
	private String curso = null;

	public Alumno() {
		super();
	}

	public Alumno(String id) {
		this.id = id;
	}

	public Alumno(String id, String nombre, String primerApellido,
			String segundoApellido, String curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.curso = curso;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public static List<String> buscarTodosLosCursos() {
		log.info("Inicio metodo buscarTodosLosCursos");

		String consultaSQL = "select distinct(curso) from alum_alumno";

		DataBaseHelper<String> helper = new DataBaseHelper<String>();

		List<String> listaDeCursos = helper.seleccionarRegistros(consultaSQL,
				String.class);

		log.info("Fin metodo buscarTodosLosCursos");

		return listaDeCursos;
	}

	public void insertarAlumno() {
		log.info("Inicio metodo insertarAlumno");
		String consultaSQL = "insert into alum_alumno (id, nombre, primerApellido, segundoApellido, curso) values";

		consultaSQL += "('" + this.id + "','" + this.nombre + "','"
				+ this.primerApellido + "','" + this.segundoApellido + "','"
				+ this.curso + "')";

		DataBaseHelper<Alumno> datos = new DataBaseHelper<Alumno>();

		datos.modificarRegistro(consultaSQL);
		log.info("Fin metodo insertarAlumno");
	}

	public static List<Alumno> buscarTodosLosAlumnos() {
		log.info("Inicio metodo buscarTodosLosAlumnos");

		String consultaSQL = "select id, nombre, primerApellido, segundoApellido, curso from alum_alumno";

		DataBaseHelper<Alumno> helper = new DataBaseHelper<Alumno>();

		List<Alumno> listaDeAlumnos = helper.seleccionarRegistros(consultaSQL,
				Alumno.class);

		log.info("Fin metodo buscarTodosLosAlumnos");

		return listaDeAlumnos;
	}

	public void borrarAlumno() {
		log.info("Inicio metodo borrarAlumno");

		String consultaSQL = "delete from alum_alumno where id = '" + this.id
				+ "'";

		DataBaseHelper<Alumno> helper = new DataBaseHelper<Alumno>();

		helper.modificarRegistro(consultaSQL);

		log.info("Fin metodo borrarAlumno");
	}

	public static Alumno BuscarAlumno(String id) {

		log.info("Inicio metodo BuscarAlumno");

		String consultaSQL = "select id, nombre, primerApellido, segundoApellido, curso from alum_alumno where id = '"
				+ id + "'";

		DataBaseHelper<Alumno> helper = new DataBaseHelper<Alumno>();

		List<Alumno> listaDeAlumnos = helper.seleccionarRegistros(consultaSQL,
				Alumno.class);

		log.info("Fin metodo BuscarAlumno");

		return listaDeAlumnos.get(0);
	}

	public void modificarAlumno() {
		log.info("Inicio metodo modificarAlumno");

		String consultaSQL = "update alum_alumno set id= '" + this.id
				+ "', nombre = '" + this.nombre + "', primerApellido = '"
				+ this.primerApellido + "', segundoApellido = '"
				+ this.segundoApellido + "', curso = '" + this.curso
				+ "' where id= '" + this.id + "'";

		DataBaseHelper<Alumno> helper = new DataBaseHelper<Alumno>();

		helper.modificarRegistro(consultaSQL);
		log.info("Fin metodo modificarAlumno");
	}

	public static List<Alumno> buscarAlumnosPorCurso(String curso) {
		log.info("Inicio metodo buscarAlumnosPorCurso");

		String consultaSQL = "select id, nombre, primerApellido, segundoApellido, curso from alum_alumno "
				+ "where curso = '" + curso + "'";

		DataBaseHelper<Alumno> helper = new DataBaseHelper<Alumno>();

		List<Alumno> listaDeAlumnos = helper.seleccionarRegistros(consultaSQL,
				Alumno.class);

		log.info("Fin metodo buscarAlumnosPorCurso");

		return listaDeAlumnos;
	}
}
