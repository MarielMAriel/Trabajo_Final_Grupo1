package fi.unju.edu.ar;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;



@Component
public class AutenticacionSaccessHandler implements AuthenticationSuccessHandler{

	private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		boolean tipoEmpresa=false;
		boolean tipoEmpledo=false;
		Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("empresa")) {
				tipoEmpresa=true;
				break;
			}else {
				if(grantedAuthority.getAuthority().equals("empleado")) {
					tipoEmpledo=true;
					break;
				}
			}
			
		}
		if(tipoEmpresa) {
			redirectStrategy.sendRedirect(request, response,"/login");
		}else {
			if(tipoEmpledo) {
				redirectStrategy.sendRedirect(request, response,"/indexEmpl" );
			}
		}
	
	
	}

}
