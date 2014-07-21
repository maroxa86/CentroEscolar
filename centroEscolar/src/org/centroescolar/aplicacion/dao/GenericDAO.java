package org.centroescolar.aplicacion.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, Id extends Serializable> {
	public List<T> buscarTodos();
}
