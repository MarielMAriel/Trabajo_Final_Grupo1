package fi.unju.edu.ar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fi.unju.edu.ar.entity.Curso;

@Repository
public interface ICursoDao extends CrudRepository<Curso, Long>{
	@Query("from Curso e order by e.id")
	public List<Curso> obtenerCurso();

}
