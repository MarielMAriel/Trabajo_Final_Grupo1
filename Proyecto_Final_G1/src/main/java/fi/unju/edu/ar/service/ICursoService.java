package fi.unju.edu.ar.service;

import java.util.List;

import fi.unju.edu.ar.entity.Curso;

public interface ICursoService {
	
	public Curso nuevoCurso();
	public List<Curso> listaCursos();
	public Curso buscarCurso(Long ids);

}
