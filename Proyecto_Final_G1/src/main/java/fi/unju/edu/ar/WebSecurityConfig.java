package fi.unju.edu.ar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fi.unju.edu.ar.serviceImp.loginServiceImp;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	String[] resourse = new String[] {
			"/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**","/webjars/**"
	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers(resourse).permitAll()
			.antMatchers("/", "/inicio","/NuevoEmpr","/guardarEmpresa").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/logEmpr")
			.permitAll()
			.defaultSuccessUrl("/indexEmpr")
			.failureUrl("/logEmpr?error=true")
			.usernameParameter("cuit")
			.usernameParameter("contrasenia")
			.and()
		.logout()
			.permitAll()
			.logoutSuccessUrl("/logEmpr?logout");
	}
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder=new BCryptPasswordEncoder(4);
		return bCryptPasswordEncoder;
	}
	@Autowired
	loginServiceImp empresauserDetailsService;
	//este metodo esta erroneo
	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(empresauserDetailsService).passwordEncoder(passwordEncoder());		
	}*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(empresauserDetailsService).passwordEncoder(passwordEncoder());		
	}	
	
	
	
}
