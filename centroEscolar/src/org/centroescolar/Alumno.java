package org.centroescolar;

import java.util.List;

public class Alumno {

	private String id = null;
	private String nombre = null;
	private String primerApellido = null;
	private String segundoApellido = null;
	private String curso = null;

	public Alumno(){
		super();
	}
	
	public Alumno(String id){
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

	public List<String> buscarTodosLosCursos() {
		
		String consultaSQL = "select distinct(curso) from alum_alumno";
		
		DataBaseHelper<String> helper = new DataBaseHelper<String>();
		
		List<String> listaDeCursos = helper.seleccionarRegistros(consultaSQL, String.class);
		
		return listaDeCursos;
	}

	public void insertarAlumno() {
		
		String consultaSQL = "insert into alum_alumno (id, nombre, primerApellido, segundoApellido, curso) values";
		
		consultaSQL += "('" + this.id + "','" + this.nombre + "','"
				+ this.primerApellido + "','" + this.segundoApellido + "','"
				+ this.curso + "')";
		
		DataBaseHelper<Alumno> datos = new DataBaseHelper<Alumno>();
		
		datos.modificarRegistro(consultaSQL);
	}

	public List<Alumno> buscarTodosLosAlumnos() {
		String consultaSQL = "select id, nombre, primerApellido, segundoApellido, curso from alum_alumno";
		
		DataBaseHelper<Alumno> helper = new DataBaseHelper<Alumno>();
		
		List<Alumno> listaDeAlumnos = helper.seleccionarRegistros(consultaSQL, Alumno.class);
		
		return listaDeAlumnos;
	}
	
	public void borrar(){
		
		String consultaSQL = "delete from alum_alumno where id = '" + this.id + "'";
		
		DataBaseHelper<Alumno> helper = new DataBaseHelper<Alumno>();
		
		helper.modificarRegistro(consultaSQL);
	}
}
