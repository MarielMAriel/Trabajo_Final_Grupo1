package fi.unju.edu.ar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

//import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import fi.unju.edu.ar.entity.Empresa;
@Repository
public interface IEmpresaDAO extends CrudRepository<Empresa, Long >{//puede ser jpaRepository o CrudRepository
	/**
	 * Metodo que se usa para buscar la empresa por cuit
	 * @param cuit
	 */
	
	public Empresa findByCuit(String cuit);
	@Query("from Empresa e order by e.cuit")
	public List<Empresa> obtenerEmpresa();
	
}
