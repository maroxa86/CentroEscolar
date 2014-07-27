package org.centroescolar.aplicacion.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManagerFactory;

public interface GenericDAO<T, Id extends Serializable> {
	public List<T> buscarTodos();
	public EntityManagerFactory getEntityManagerFactory();
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory);
}
