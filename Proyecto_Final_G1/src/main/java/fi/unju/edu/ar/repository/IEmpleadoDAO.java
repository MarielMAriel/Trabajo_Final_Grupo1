package fi.unju.edu.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fi.unju.edu.ar.entity.Empleado;

public interface IEmpleadoDAO extends JpaRepository<Empleado, Long >{
	
}
