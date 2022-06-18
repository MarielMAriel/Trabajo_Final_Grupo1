package fi.unju.edu.ar.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fi.unju.edu.ar.entity.Empleado;

	
 public interface IUsuarioCRepository extends CrudRepository<Empleado,Long>{
	
	public Optional<Empleado> findByDni(Long dni);

}
