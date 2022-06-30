package fi.unju.edu.ar.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import fi.unju.edu.ar.entity.Empleado;
//eliminar luego y pasarlo a una rama para commit
@Repository
public interface IEmpleadoDAO extends JpaRepository<Empleado, Long >{
	@Query("from Empleado e order by e.dni")
	public List<Empleado> obtenerEmpleado();
	
	
	public List<Empleado> findByProvincia(String provincia);
	
	public List<Empleado> findByProfecion(String profecion);
	
}
