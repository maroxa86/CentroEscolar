package org.centroescolar.aplicacion.bo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ALUM_ALUMNO")
public class Alumno {

	@Id
	private int id = 0;
	private String nombre = null;
	private String primerApellido = null;
	private String segundoApellido = null;
	@ManyToOne
	@JoinColumn(name = "curso")
	private Curso curso = null;

	public Alumno() {
		super();
	}

	public Alumno(int id) {
		this.id = id;
	}

	public Alumno(int id, String nombre, String primerApellido,
			String segundoApellido, Curso curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.curso = curso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
