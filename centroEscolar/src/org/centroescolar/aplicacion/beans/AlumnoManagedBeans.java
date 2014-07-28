package org.centroescolar.aplicacion.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.centroescolar.aplicacion.bo.Alumno;
import org.centroescolar.aplicacion.bo.Curso;
import org.centroescolar.aplicacion.servicios.ServicioAlumnos;

@ManagedBean(name="AlumnoManagedBeans")
@SessionScoped
public class AlumnoManagedBeans {
	
	private int id;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private int curso;
	private List<SelectItem> listaDeCursos;
	private List<Alumno> listaDeAlumnos;
	
	@ManagedProperty("#{servicioAlumnos}")
	private ServicioAlumnos servicioAlumnos;
	
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
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public List<SelectItem> getListaDeCursos() {
		return listaDeCursos;
	}
	public void setListaDeCursos(List<SelectItem> listaDeCursos) {
		this.listaDeCursos = listaDeCursos;
	}
	public List<Alumno> getListaDeAlumnos() {
		return listaDeAlumnos;
	}
	public void setListaDeAlumnos(List<Alumno> listaDeAlumnos) {
		this.listaDeAlumnos = listaDeAlumnos;
	}
	
	public ServicioAlumnos getServicioAlumnos() {
		return servicioAlumnos;
	}
	public void setServicioAlumnos(ServicioAlumnos servicioAlumnos) {
		this.servicioAlumnos = servicioAlumnos;
	}
	
	@PostConstruct
	public void init(){
		
		listaDeAlumnos = servicioAlumnos.buscarTodosLosAlumnos();
		System.out.println(listaDeAlumnos);
		List<Curso> cursos = servicioAlumnos.buscarTodosLosCursos();
		listaDeCursos = new ArrayList<SelectItem>();
		for(Curso curso : cursos){
			listaDeCursos.add(new SelectItem(curso.getId(),curso.getCurso()));
		}
		
		System.out.println(listaDeCursos);
	}
	
	public void insertar(ActionEvent evento){
		servicioAlumnos.insertarAlumno(new Alumno(id,nombre,primerApellido, segundoApellido, new Curso(curso)));
		setListaDeAlumnos(servicioAlumnos.buscarTodosLosAlumnos());
		curso = 0;
	}
	
	public void borrar(String id){
		servicioAlumnos.borrarAlumno(new Alumno(Integer.parseInt(id)));
		setListaDeAlumnos(servicioAlumnos.buscarTodosLosAlumnos());
	}
	
	public void filtrar(ValueChangeEvent evento){
		int idCurso = Integer.parseInt(evento.getComponent().getAttributes().get("value").toString());
		
		if(idCurso != 0){
			setListaDeAlumnos(servicioAlumnos.buscarAlumnosPorCurso(new Curso(idCurso)));
		}
		else{
			setListaDeAlumnos(servicioAlumnos.buscarTodosLosAlumnos());
		}
	}
	
	public void editar(String id){
		Alumno alumno = servicioAlumnos.BuscarAlumno(Integer.parseInt(id));
		this.id = alumno.getId();
		nombre = alumno.getNombre();
		primerApellido = alumno.getPrimerApellido();
		segundoApellido = alumno.getSegundoApellido();
		curso = alumno.getCurso().getId();
	}
	
	public void formularioInsertar(ActionEvent evento){
		id = 0;
		nombre = "";
		primerApellido = "";
		segundoApellido = "";
		curso = 0;
	}
	
	public void modificar(ActionEvent evento){
		servicioAlumnos.modificarAlumno(new Alumno(id,nombre,primerApellido, segundoApellido, new Curso(curso)) );
		setListaDeAlumnos(servicioAlumnos.buscarTodosLosAlumnos());
		curso = 0;
	}
}
