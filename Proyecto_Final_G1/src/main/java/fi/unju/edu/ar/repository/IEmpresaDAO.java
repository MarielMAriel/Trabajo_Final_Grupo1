package fi.unju.edu.ar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

//import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fi.unju.edu.ar.entity.Empleado;
import fi.unju.edu.ar.entity.Empresa;
@Repository
public interface IEmpresaDAO extends CrudRepository<Empresa, Long >{//puede ser jpaRepository o CrudRepository
	//metodo que se usa para buscar la empresa que se esta logueando 1er agr
	public Empresa findByCuit(String cuit);
	@Query("from Empresa e order by e.cuit")
	public List<Empresa> obtenerEmpresa();
	
}
