package fi.unju.edu.ar.serviceImp;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fi.unju.edu.ar.entity.Empleado;
import fi.unju.edu.ar.repository.IEmpleadoDAO;
import fi.unju.edu.ar.service.IEmpleadoService;

@Service
public class EmpleadoServiceImp implements IEmpleadoService{
	//agregue private
	private static final Log LOGGER = LogFactory.getLog(LoginServiceImp.class);

	@Autowired
	private IEmpleadoDAO empleadoDaoImp;
	@Override
	public void guardarEmplado(Empleado empleado) {
		//String pw = empleado.getContrasenia();
		//BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder(4);
		//empleado.setContrasenia(bCryptPasswordEncoder.encode(pw));
		LOGGER.info("Se Guardo Empleado en la BD "+empleado);

		empleadoDaoImp.save(empleado);
	}
	@Override
	public List<Empleado> getListaEmpleado() {
		// TODO Auto-generated method stub
		LOGGER.info("Se devuele una lista de empleados ");
		
		return empleadoDaoImp.obtenerEmpleado();
	}
	@Override
	public Empleado getEmpleado() {
		// TODO Auto-generated method stub
	LOGGER.info("Se devuele una instancia de un nuevo empleado ");

		return new Empleado();
	}
	@Override
	public List<Empleado> getListaProvincia(String provincia) {
		// TODO Auto-generated method stub
		LOGGER.info("Se devuele una lista empleados segun la  provincia "+provincia);

		return empleadoDaoImp.findByProvincia(provincia);
	}
	@Override
	public List<Empleado> getListaProfecion(String profecion) {
		// TODO Auto-generated method stub
		LOGGER.info("Se devuele una lista de empleados segun la profesion "+profecion);

		return empleadoDaoImp.findByProfecion(profecion);
	}
	@Override
	public Empleado buscar(String dni) {
		// TODO Auto-generated method stub
		LOGGER.info("Se retorna el empleado regstrado con este dni"+ dni);

		return empleadoDaoImp.findByDni(dni);
	}
	

}
