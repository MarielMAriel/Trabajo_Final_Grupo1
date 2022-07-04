package fi.unju.edu.ar.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fi.unju.edu.ar.entity.Institucion;
@Repository
public interface InstitucionDao extends CrudRepository<Institucion, Long>{
	
	public Optional<Institucion> findByCuit(String cuit);
	
	

}
