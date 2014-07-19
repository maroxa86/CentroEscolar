package org.centroescolar.aplicacion.bo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.centroescolar.aplicacion.HibernateHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name="CUR_CURSO")
public class Curso {
	
	@Id
	@Column(name="idCurso")
	private int id;
	private String curso;
	@OneToMany
	@JoinColumn(name="curso")
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

	public static List<Curso> buscarTodosLosCursos(){
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		List<Curso> listaDeCursos = session.createQuery("from Curso curso").list();
		session.close();
		return listaDeCursos;
	}
}
