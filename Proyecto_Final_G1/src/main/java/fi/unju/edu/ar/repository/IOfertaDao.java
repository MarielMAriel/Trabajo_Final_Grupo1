package fi.unju.edu.ar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import fi.unju.edu.ar.entity.OfertaLab;
/**
 *Es una interfaz que se extiende a los metodos de crudrepository utilizandolos 
*para la entidad  Oferta que tiene una clave primaria valores Long.
*y que crea un metodo de busqueda de codigo de producucto(Oferta)
*/  
public interface IOfertaDao extends CrudRepository<OfertaLab, Long>{
	@Query("from OfertaLab e order by e.puestoReq")
	public List<OfertaLab> ofertasEmpr();
	
	public Optional<OfertaLab> findById(Long id);
	
}
