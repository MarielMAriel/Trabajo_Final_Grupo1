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

import fi.unju.edu.ar.entity.Empresa;
import fi.unju.edu.ar.repository.IEmpresaDAO;

@Service
public class loginServiceImp implements UserDetailsService{
	@Autowired
	IEmpresaDAO iEmpresa;
	
	@Override
	public UserDetails loadUserByUsername(String cuit) throws UsernameNotFoundException {//user detail sirve para recuperar para guardar  
		Empresa empresaEncontrado = iEmpresa.findByCuit(cuit).orElseThrow(()->new UsernameNotFoundException("login invalido"));
		
		List<GrantedAuthority> typos= new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(empresaEncontrado.getTipo());
		typos.add(grantedAuthority);
		UserDetails user =(UserDetails)new User(cuit, empresaEncontrado.getContrasenia(), typos);
		return user;
	}
	
	

}
