package org.maroxa86.cge.aplicacion.servicios;

import java.util.List;

import org.maroxa86.cge.aplicacion.bo.Alumno;
import org.maroxa86.cge.aplicacion.bo.Curso;
import org.maroxa86.cge.aplicacion.dao.AlumnoDAO;
import org.maroxa86.cge.aplicacion.dao.CursoDAO;

public interface AlumnoService {
	
	public AlumnoDAO getAlumnoDAO();
    
	public void setAlumnoDAO(AlumnoDAO alumnoDAO);
    
	public CursoDAO getCursoDAO();
    
    public void setCursoDAO(CursoDAO cursoDAO);
	
    public void salvarAlumno(Alumno alumno);

    public void borrarAlumno(Alumno alumno);

    public List<Alumno> buscarTodosLosAlumnos();

    public List<Curso> buscarCursosAlumnos();

    public Alumno buscarAlumnoPorClave(String id);

    public Curso buscarCursoPorClave(int id);

    public List<Alumno> buscarAlumnosPorCurso(int cursoId);

    public void insertarAlumno(Alumno alumno);
}
