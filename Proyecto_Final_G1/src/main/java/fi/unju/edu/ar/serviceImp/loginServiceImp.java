package fi.unju.edu.ar.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import fi.unju.edu.ar.entity.Usuario;
import fi.unju.edu.ar.repository.IUsuarioDao;

@Service
public class loginServiceImp implements UserDetailsService{
	@Autowired
	IUsuarioDao iUsuario;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {//user detail sirve para recuperar para guardar  
		Usuario usuarioEncontrado = iUsuario.findById(id).orElseThrow(()->new UsernameNotFoundException("login invalido"));
		
		List<GrantedAuthority> typos= new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getTipo());
		typos.add(grantedAuthority);
		UserDetails user =(UserDetails)new User(id, usuarioEncontrado.getContrasenia(), typos);
		return user;
	}
	
	

}
