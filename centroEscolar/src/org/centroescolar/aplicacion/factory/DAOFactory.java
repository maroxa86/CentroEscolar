package org.centroescolar.aplicacion.factory;

import org.centroescolar.aplicacion.dao.AlumnoDAO;
import org.centroescolar.aplicacion.dao.CursoDAO;

public interface DAOFactory {
	public CursoDAO getCursoDAO();
	public AlumnoDAO getAlumnoDAO();
}
