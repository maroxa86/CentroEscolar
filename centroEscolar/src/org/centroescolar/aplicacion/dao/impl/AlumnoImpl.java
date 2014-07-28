package org.centroescolar.aplicacion.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;
import org.centroescolar.aplicacion.dao.AlumnoDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AlumnoImpl extends GenericImpl<Alumno, String> implements AlumnoDAO{
	
	private static final Logger log = Logger.getLogger(AlumnoImpl.class);

	@Transactional(readOnly=true)
	public List<Alumno> buscarAlumnosPorCurso(Curso curso) {
		log.info("Inicio metodo buscarAlumnosPorCurso");
		
		TypedQuery<Alumno> consulta = getManager().createQuery(
						"SELECT alumno FROM Alumno alumno where alumno.curso=?1 order by alumno.id",
						Alumno.class);
		consulta.setParameter(1, curso);

		log.info("Fin metodo buscarAlumnosPorCurso");

		return consulta.getResultList();
	}
	
	@Transactional(readOnly=true)
	public Alumno BuscarAlumno(int id) {

		log.info("Inicio metodo BuscarAlumno");

		Alumno alumno = getManager().find(Alumno.class, id);

		log.info("Fin metodo BuscarAlumno");

		return alumno;
	}
}
