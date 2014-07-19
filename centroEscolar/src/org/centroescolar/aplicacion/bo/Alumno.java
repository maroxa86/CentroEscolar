package org.centroescolar.aplicacion.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceException;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.centroescolar.aplicacion.JPAHelper;

@Entity
@Table(name = "ALUM_ALUMNO")
public class Alumno {

	private static final Logger log = Logger.getLogger(Alumno.class);
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

	public void insertarAlumno() {
		log.info("Inicio metodo insertarAlumno");

		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(this);
			tx.commit();
		} catch (PersistenceException e) {
			manager.getTransaction().rollback();
			throw e;
		} finally {
			manager.close();
		}

		log.info("Fin metodo insertarAlumno");
	}

	public static List<Alumno> buscarTodosLosAlumnos() {
		log.info("Inicio metodo buscarTodosLosAlumnos");

		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Alumno> consulta = manager.createQuery(
				"SELECT alumno FROM Alumno alumno JOIN FETCH alumno.curso order by alumno.id",
				Alumno.class);
		List<Alumno> listaDeAlumnos = null;
		try {
			listaDeAlumnos = consulta.getResultList();
		} finally {
			manager.close();
		}

		log.info("Fin metodo buscarTodosLosAlumnos");

		return listaDeAlumnos;
	}

	public void borrarAlumno() {
		log.info("Inicio metodo borrarAlumno");

		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.remove(manager.merge(this));
			tx.commit();
		} catch (PersistenceException e) {
			manager.getTransaction().rollback();
			throw e;
		} finally {
			manager.close();
		}

		log.info("Fin metodo borrarAlumno");
	}

	public static Alumno BuscarAlumno(int id) {

		log.info("Inicio metodo BuscarAlumno");

		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Alumno> consulta = manager.createQuery(
				"SELECT alumno FROM Alumno alumno JOIN FETCH alumno.curso where alumno.id=?1",
				Alumno.class);
		consulta.setParameter(1, id);
		Alumno alumno = null;
		try {
			alumno = consulta.getSingleResult();
		} finally {
			manager.close();
		}

		log.info("Fin metodo BuscarAlumno");

		return alumno;
	}

	public void modificarAlumno() {
		log.info("Inicio metodo modificarAlumno");

		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.merge(this);
			tx.commit();
		} catch (PersistenceException e) {
			manager.getTransaction().rollback();
			throw e;
		} finally {
			manager.close();
		}

		log.info("Fin metodo modificarAlumno");
	}

	public static List<Alumno> buscarAlumnosPorCurso(Curso curso) {
		log.info("Inicio metodo buscarAlumnosPorCurso");

		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Alumno> consulta = manager.createQuery(
				"SELECT alumno FROM Alumno alumno where alumno.curso=?1 order by alumno.id",
				Alumno.class);
		consulta.setParameter(1, curso);
		List<Alumno> listaDeAlumnos = null;
		try {
			listaDeAlumnos = consulta.getResultList();
		} finally {
			manager.close();
		}

		log.info("Fin metodo buscarAlumnosPorCurso");

		return listaDeAlumnos;
	}
}
