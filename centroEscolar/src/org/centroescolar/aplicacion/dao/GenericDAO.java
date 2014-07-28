package org.centroescolar.aplicacion.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, Id extends Serializable> {
	public List<T> buscarTodos();
	public void insertar(T objeto);
	public void borrar(T objeto);
	public void modificar(T objeto);
}
