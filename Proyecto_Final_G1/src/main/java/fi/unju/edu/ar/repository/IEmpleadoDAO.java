package fi.unju.edu.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fi.unju.edu.ar.entity.Empleado;
//eliminar luego y pasarlo a una rama para commit
@Repository
public interface IEmpleadoDAO extends JpaRepository<Empleado, Long >{
	
}
