package fi.unju.edu.ar.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fi.unju.edu.ar.entity.Empleado;
import fi.unju.edu.ar.entity.Empresa;
import fi.unju.edu.ar.entity.Usuario;
import fi.unju.edu.ar.repository.IUsuarioDao;

import fi.unju.edu.ar.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService{
	@Autowired
	private IUsuarioDao usuarioDaoImp;


	@Override
	public Usuario getUsuario() {
		// TODO Auto-generated method stub
		return  new Usuario();
	}

	@Override
	public void crear(Usuario unUsuario) {
		String pw = unUsuario.getContrasenia();
		BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder(4);
		unUsuario.setContrasenia(bCryptPasswordEncoder.encode(pw));
		usuarioDaoImp.save(unUsuario);
	}

	@Override
	public Usuario setearUsuario(Empresa empresa) {
		Usuario usu = new Usuario();
		usu.setId(empresa.getCuit());
		usu.setContrasenia(empresa.getContrasenia());
		usu.setTipo(empresa.getTipo());
		return usu;
		
	}

	@Override
	public Usuario setearUsuarioi(Empleado empleado) {
		Usuario usu = new Usuario();
		usu.setId(empleado.getDni());
		usu.setContrasenia(empleado.getContrasenia());
		usu.setTipo(empleado.getTipo());
		return usu;
	}





}
