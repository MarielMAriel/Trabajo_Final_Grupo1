package fi.unju.edu.ar.service;

import java.util.List;
import java.util.Optional;

import fi.unju.edu.ar.entity.Empleado;

public interface IEmpleadoService {
	public Empleado getEmpleado();
	public void guardarEmplado(Empleado empleado);
	public List<Empleado>getListaEmpleado();
	public List<Empleado>getListaProvincia(String provincia);
	public List<Empleado>getListaProfecion(String profecion);
	public Empleado buscar(String dni);
		
}
