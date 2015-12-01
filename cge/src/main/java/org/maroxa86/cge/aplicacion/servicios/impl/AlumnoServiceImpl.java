package org.maroxa86.cge.aplicacion.servicios.impl;

import java.util.List;

import org.maroxa86.cge.aplicacion.bo.Alumno;
import org.maroxa86.cge.aplicacion.bo.Curso;
import org.maroxa86.cge.aplicacion.dao.AlumnoDAO;
import org.maroxa86.cge.aplicacion.dao.CursoDAO;
import org.maroxa86.cge.aplicacion.servicios.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="alumnoService")
public class AlumnoServiceImpl implements AlumnoService {

    private AlumnoDAO alumnoDAO = null;
    private CursoDAO cursoDAO = null;

    public AlumnoDAO getAlumnoDAO() {
		return alumnoDAO;
	}

    @Autowired
	public void setAlumnoDAO(AlumnoDAO alumnoDAO) {
		this.alumnoDAO = alumnoDAO;
	}

	public CursoDAO getCursoDAO() {
		return cursoDAO;
	}

	@Autowired
	public void setCursoDAO(CursoDAO cursoDAO) {
		this.cursoDAO = cursoDAO;
	}

	@Override
	@Transactional
    public void salvarAlumno(Alumno alumno) {
        alumnoDAO.salvar(alumno);
    }

    @Override
    @Transactional
    public void borrarAlumno(Alumno alumno) {
        alumnoDAO.borrar(alumno);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Alumno> buscarTodosLosAlumnos() {
        return alumnoDAO.buscarTodos();
    }

    @Override
    @Transactional(readOnly=true)
    public List<Curso> buscarCursosAlumnos() {
        return cursoDAO.buscarTodos();
    }

    @Override
    @Transactional(readOnly=true)
    public Alumno buscarAlumnoPorClave(String id) {
        return alumnoDAO.buscarPorClave(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Curso buscarCursoPorClave(int id) {
        return cursoDAO.buscarPorClave(id);
    }

    @Override
    public List<Alumno> buscarAlumnosPorCurso(int cursoId) {
        Curso curso = cursoDAO.buscarPorClave(cursoId);
        return alumnoDAO.buscarPorCurso(curso);
    }

    @Override
    @Transactional
    public void insertarAlumno(Alumno alumno) {
        alumnoDAO.insertar(alumno);
    }

}
