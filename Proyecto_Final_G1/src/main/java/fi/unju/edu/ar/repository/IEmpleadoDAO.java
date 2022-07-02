package fi.unju.edu.ar.repository;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import fi.unju.edu.ar.entity.Empleado;

@Repository
public interface IEmpleadoDAO extends JpaRepository<Empleado, Long >{
	/** 
	 * Se obtiene la lista empleados
	 *	 */
	@Query("from Empleado e order by e.dni")
	public List<Empleado> obtenerEmpleado();
	/**
	 * Lista empleados y estos serán buscados por provincia y profesión.
	 * 
	 * @param provincia
	 * @param profecion
	 */
	public List<Empleado> findByProvincia(String provincia);
	public List<Empleado> findByProfecion(String profecion);
	public Empleado findByDni(String dni);
	
}
