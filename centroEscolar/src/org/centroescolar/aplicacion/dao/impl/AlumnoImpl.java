package org.centroescolar.aplicacion.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;
import org.centroescolar.aplicacion.dao.AlumnoDAO;

public class AlumnoImpl extends GenericImpl<Alumno, String> implements AlumnoDAO{
	
	private static final Logger log = Logger.getLogger(AlumnoImpl.class);
	
	public void insertarAlumno(Alumno alumno) {
		log.info("Inicio metodo insertarAlumno");

		EntityManager manager = getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(alumno);
			tx.commit();
		} catch (PersistenceException e) {
			manager.getTransaction().rollback();
			throw e;
		} finally {
			manager.close();
		}

		log.info("Fin metodo insertarAlumno");
	}

	public void borrarAlumno(Alumno alumno) {
		log.info("Inicio metodo borrarAlumno");

		EntityManager manager = getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.remove(manager.merge(alumno));
			tx.commit();
		} catch (PersistenceException e) {
			manager.getTransaction().rollback();
			throw e;
		} finally {
			manager.close();
		}

		log.info("Fin metodo borrarAlumno");
	}

	public Alumno BuscarAlumno(int id) {

		log.info("Inicio metodo BuscarAlumno");

		EntityManager manager = getEntityManagerFactory().createEntityManager();
		TypedQuery<Alumno> consulta = manager
				.createQuery(
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

	public void modificarAlumno(Alumno alumno) {
		log.info("Inicio metodo modificarAlumno");

		EntityManager manager = getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.merge(alumno);
			tx.commit();
		} catch (PersistenceException e) {
			manager.getTransaction().rollback();
			throw e;
		} finally {
			manager.close();
		}

		log.info("Fin metodo modificarAlumno");
	}

	public List<Alumno> buscarAlumnosPorCurso(Curso curso) {
		log.info("Inicio metodo buscarAlumnosPorCurso");

		EntityManager manager = getEntityManagerFactory().createEntityManager();
		TypedQuery<Alumno> consulta = manager
				.createQuery(
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
