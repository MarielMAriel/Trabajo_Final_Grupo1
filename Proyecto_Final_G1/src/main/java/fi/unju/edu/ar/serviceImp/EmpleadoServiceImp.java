package fi.unju.edu.ar.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.unju.edu.ar.entity.Empleado;
import fi.unju.edu.ar.repository.IEmpleadoDAO;
import fi.unju.edu.ar.service.IEmpleadoService;

@Service
public class EmpleadoServiceImp implements IEmpleadoService{
	//agregue private
	@Autowired
	private IEmpleadoDAO empleadoDaoImp;
	@Override
	public void guardarEmplado(Empleado empleado) {
		// TODO Auto-generated method stub
		empleadoDaoImp.save(empleado);
	}
	@Override
	public List<Empleado> getListaEmpleado() {
		// TODO Auto-generated method stub
		return empleadoDaoImp.obtenerEmpleado();
	}
	@Override
	public Empleado getEmpleado() {
		// TODO Auto-generated method stub
		return new Empleado();
	}
	

}
