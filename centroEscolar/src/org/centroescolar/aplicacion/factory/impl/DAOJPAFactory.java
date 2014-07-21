package org.centroescolar.aplicacion.factory.impl;

import org.centroescolar.aplicacion.dao.AlumnoDAO;
import org.centroescolar.aplicacion.dao.CursoDAO;
import org.centroescolar.aplicacion.dao.impl.AlumnoImpl;
import org.centroescolar.aplicacion.dao.impl.CursoImpl;
import org.centroescolar.aplicacion.factory.DAOFactory;

public class DAOJPAFactory implements DAOFactory{
	
	public CursoDAO getCursoDAO(){
		return new CursoImpl();
	}
	
	public AlumnoDAO getAlumnoDAO(){
		return new AlumnoImpl();
	}
}
