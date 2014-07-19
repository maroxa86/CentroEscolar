package org.centroescolar.aplicacion.bo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.centroescolar.aplicacion.JPAHelper;

@Entity
@Table(name = "CUR_CURSO")
public class Curso {

	@Id
	@Column(name = "idCurso")
	private int id;
	private String curso;
	@OneToMany
	@JoinColumn(name = "curso")
	private List<Alumno> listaDeAlumnos;

	public Curso() {
		super();
	}

	public Curso(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public List<Alumno> getListaDeAlumnos() {
		return listaDeAlumnos;
	}

	public void setListaDeAlumnos(List<Alumno> listaDeAlumnos) {
		this.listaDeAlumnos = listaDeAlumnos;
	}

	public static List<Curso> buscarTodosLosCursos() {
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Curso> consulta = manager.createQuery(
				"SELECT curso FROM Curso curso", Curso.class);
		List<Curso> listaDeCursos = null;
		try {
			listaDeCursos = consulta.getResultList();
		} finally {
			manager.close();
		}

		return listaDeCursos;
	}
}
