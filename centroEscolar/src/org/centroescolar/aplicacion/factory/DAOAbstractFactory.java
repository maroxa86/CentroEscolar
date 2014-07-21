package org.centroescolar.aplicacion.factory;

import org.centroescolar.aplicacion.factory.impl.DAOJPAFactory;

public abstract class DAOAbstractFactory {
	public static DAOFactory getInstance(){
		String tipo = "JPA";
		if(tipo.equals("JPA")){
			return new DAOJPAFactory();
		}
		return null;
	}
}
