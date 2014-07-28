package org.centroescolar.aplicacion.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.centroescolar.aplicacion.dao.GenericDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public abstract class GenericImpl<T, Id extends Serializable> implements
		GenericDAO<T, Id> {

	private static final Logger log = Logger.getLogger(GenericImpl.class);

	private Class<T> claseDePersistencia;
	
	@PersistenceContext
	private EntityManager manager;

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	@SuppressWarnings("unchecked")
	public GenericImpl() {
		this.claseDePersistencia = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> buscarTodos() {
		List<T> listaDeObjetos = null;
		TypedQuery<T> consulta = manager.createQuery("select o from "
				+ claseDePersistencia.getSimpleName() + " o",
				claseDePersistencia);
		listaDeObjetos = consulta.getResultList();
		return listaDeObjetos;
	}

	@Transactional
	public void insertar(T objeto) {
		log.info("Inicio metodo insertarAlumno");

		getManager().persist(objeto);

		log.info("Fin metodo insertarAlumno");
	}

	@Transactional
	public void borrar(T objeto) {
		log.info("Inicio metodo borrarAlumno");

		getManager().remove(getManager().merge(objeto));

		log.info("Fin metodo borrarAlumno");
	}

	@Transactional
	public void modificar(T objeto) {
		log.info("Inicio metodo modificarAlumno");

		getManager().merge(objeto);

		log.info("Fin metodo modificarAlumno");
	}

}
