package org.maroxa86.cge.aplicacion.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.maroxa86.cge.aplicacion.bo.Alumno;
import org.maroxa86.cge.aplicacion.bo.Curso;
import org.maroxa86.cge.aplicacion.servicios.AlumnoService;

@ManagedBean(name="AlumnoManagedBeans")
@SessionScoped
public class AlumnoManagedBeans {

	private String id;
	private String nombre;
	private String apellidos;
	private String curso;
	private List<SelectItem> listaDeCursos;
	private List<Alumno> listaDeAlumnos;
	
	@ManagedProperty("#{alumnoService}")
	private AlumnoService alumnoService;
	
	public List<Alumno> getListaDeAlumnos() {
		return listaDeAlumnos;
	}

	public void setListaDeAlumnos(List<Alumno> listaDeAlumnos) {
		this.listaDeAlumnos = listaDeAlumnos;
	}

	public List<SelectItem> getListaDeCursos() {
		return listaDeCursos;
	}

	public void setListaDeCursos(List<SelectItem> listaDeCursos) {
		this.listaDeCursos = listaDeCursos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public AlumnoService getAlumnoService() {
		return alumnoService;
	}

	public void setAlumnoService(AlumnoService alumnoService) {
		this.alumnoService = alumnoService;
	}

	@PostConstruct
	public void init() {
		listaDeAlumnos = alumnoService.buscarTodosLosAlumnos();
		List<Curso> cursos = alumnoService.buscarCursosAlumnos();
		listaDeCursos = new ArrayList<SelectItem>();
		for (Curso curso : cursos) {
			listaDeCursos.add(new SelectItem(curso.getId(), curso.getDescripcion()));
		}
	}
	
	public void insertar(ActionEvent evento) {
		alumnoService.insertarAlumno(new Alumno(id, nombre, apellidos, new Curso(Integer.parseInt(curso))));
		setListaDeAlumnos(alumnoService.buscarTodosLosAlumnos());
		curso = "0";
	}

	public void borrar(String id) {
		alumnoService.borrarAlumno(new Alumno(id));
		setListaDeAlumnos(alumnoService.buscarTodosLosAlumnos());
	}

	public void filtrar(ValueChangeEvent evento) {
		int idCurso = Integer.parseInt(evento.getComponent().getAttributes().get("value").toString());
		if (idCurso != 0) {
			setListaDeAlumnos(alumnoService.buscarAlumnosPorCurso(idCurso));
		} else {
			setListaDeAlumnos(alumnoService.buscarTodosLosAlumnos());
		}
	}

	public void editar(String id) {
		Alumno alumno = alumnoService.buscarAlumnoPorClave(id);
		id = alumno.getId();
		nombre = alumno.getNombre();
		apellidos = alumno.getApellidos();
	}

	public void formularioInsertar(ActionEvent evento) {
		id = "";
		nombre = "";
		apellidos = "";
	}

	public void salvar(ActionEvent evento) {
		alumnoService.salvarAlumno(new Alumno(id, nombre, apellidos, new Curso(Integer.parseInt(curso))));
		setListaDeAlumnos(alumnoService.buscarTodosLosAlumnos());
		apellidos = "0";
	}
}
