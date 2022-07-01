package fi.unju.edu.ar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import fi.unju.edu.ar.entity.OfertaLab;

public interface IOfertaDao extends CrudRepository<OfertaLab, Long>{
	@Query("from OfertaLab e order by e.puestoReq")
	public List<OfertaLab> ofertasEmpr();
	
	public Optional<OfertaLab> findById(Long id);
	
}
