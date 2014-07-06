package org.centroescolar.aplicacion.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.centroescolar.aplicacion.HibernateHelper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name="ALUM_ALUMNO")
public class Alumno {

	private static final Logger log = Logger.getLogger(Alumno.class);
	@Id
	private int id = 0;
	private String nombre = null;
	private String primerApellido = null;
	private String segundoApellido = null;
	private String curso = null;

	public Alumno() {
		super();
	}

	public Alumno(int id) {
		this.id = id;
	}

	public Alumno(int id, String nombre, String primerApellido,
			String segundoApellido, String curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.curso = curso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public static List<Alumno> buscarTodosLosCursos() {
		log.info("Inicio metodo buscarTodosLosCursos");

		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		String consultaSQL = "select distinct(alumno.curso) from Alumno alumno";
		
		List<Alumno> listaDeCursos = session.createQuery(consultaSQL).list();
		
		session.close();

		log.info("Fin metodo buscarTodosLosCursos");

		return listaDeCursos;
	}

	public void insertarAlumno() {
		log.info("Inicio metodo insertarAlumno");
		
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.save(this);
		session.getTransaction().commit();

		log.info("Fin metodo insertarAlumno");
	}

	public static List<Alumno> buscarTodosLosAlumnos() {
		log.info("Inicio metodo buscarTodosLosAlumnos");
		
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		String consultaSQL = "from Alumno";

		List<Alumno> listaDeAlumnos = session.createQuery(consultaSQL).list();

		session.close();
		
		log.info("Fin metodo buscarTodosLosAlumnos");

		return listaDeAlumnos;
	}

	public void borrarAlumno() {
		log.info("Inicio metodo borrarAlumno");
		
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.delete(this);
		session.getTransaction().commit();
		
		log.info("Fin metodo borrarAlumno");
	}

	public static Alumno BuscarAlumno(int id) {

		log.info("Inicio metodo BuscarAlumno");

		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		Alumno alumno = (Alumno) session.get(Alumno.class, id);
		session.close();
		
		log.info("Fin metodo BuscarAlumno");

		return alumno;
	}

	public void modificarAlumno() {
		log.info("Inicio metodo modificarAlumno");

		SessionFactory factoriaSession=HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.saveOrUpdate(this);
		session.getTransaction().commit();
		
		log.info("Fin metodo modificarAlumno");
	}

	public static List<Alumno> buscarAlumnosPorCurso(String curso) {
		log.info("Inicio metodo buscarAlumnosPorCurso");
		
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		Query consultaSQL = session.createQuery("from Alumno alumno where alumno.curso=:curso");

		consultaSQL.setString("curso",curso);
		List<Alumno> listaDeAlumnos = consultaSQL.list();

		log.info("Fin metodo buscarAlumnosPorCurso");

		return listaDeAlumnos;
	}
}
