package fi.unju.edu.ar.serviceImp;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fi.unju.edu.ar.entity.Empresa;
import fi.unju.edu.ar.entity.Usuario;
//import fi.unju.edu.ar.entity.Usuario;
import fi.unju.edu.ar.repository.IEmpresaDAO;
import fi.unju.edu.ar.repository.IUsuarioDao;
//import fi.unju.edu.ar.repository.IUsuarioDao;

@Service
public class loginServiceImp implements UserDetailsService{
	
	private static final Log LOGGER = LogFactory.getLog(loginServiceImp.class);

	
	@Autowired
	private IUsuarioDao usuarioDAO;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {//user detail sirve para recuperar para guardar  
		Usuario usuarioEncontrado = usuarioDAO.findByIdentificador(id).orElseThrow(()->new UsernameNotFoundException("login invalido"));
		LOGGER.info(usuarioEncontrado);

		List<GrantedAuthority> tipos= new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getTipo());
		tipos.add(grantedAuthority);
		UserDetails user =(UserDetails)new User(id, usuarioEncontrado.getContrasenia(), tipos);
		return user;
//		Empresa empleador = empresaDao.findByCuit(cuit);
//		LOGGER.info(usuarioEncontrado);
	//	UserBuilder builder = null;
	//	if(usuarioEncontrado != null) {
	//		builder = User.withUsername(cuit);
	//		builder.disabled(false);
	//		builder.password(usuarioEncontrado.getContrasenia());
	//		builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
	//	}else {
	//		throw new UsernameNotFoundException("Usuario no encontrado");
	//	}
	//	return builder.build();
	//}
	
	

}
	}
