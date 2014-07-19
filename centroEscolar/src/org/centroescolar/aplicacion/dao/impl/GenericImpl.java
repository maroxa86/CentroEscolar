package org.centroescolar.aplicacion.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.centroescolar.aplicacion.JPAHelper;
import org.centroescolar.aplicacion.dao.GenericDAO;

public class GenericImpl<T, Id extends Serializable> implements
		GenericDAO<T, Id> {

	private Class<T> claseDePersistencia;

	@SuppressWarnings("unchecked")
	public GenericImpl() {
		this.claseDePersistencia = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public List<T> buscarTodos() {
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		List<T> listaDeObjetos = null;
		try {
			TypedQuery<T> consulta = manager.createQuery("select o from "
					+ claseDePersistencia.getSimpleName() + " o",
					claseDePersistencia);
			listaDeObjetos = consulta.getResultList();
			return listaDeObjetos;
		} finally {
			manager.close();
		}
	}

}
