package com.ziad.SpringSecEx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.ziad.SpringSecEx.service.MyUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	  private  MyUserDetailsService userDetailsService;
	  
	public SecurityConfig(MyUserDetailsService userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
	}
	
	
	

	@Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
	  
	  http.csrf(customizer -> customizer.disable());
	  http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
	  //for accessing from browser..(may affect same lines if enabled)
	  //http.formLogin(Customizer.withDefaults()); //for accessing from postman
	  http.httpBasic(Customizer.withDefaults()); http.sessionManagement(session ->
	  session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	  
	  return http.build();
	  
	  }
	 
//	  //hand coded values
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user1 = User.
//				withDefaultPasswordEncoder()
//				.username("masha")
//				.password("880")
//				.roles("USER")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user1);
//	}
	  
	  @Bean
	  public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setUserDetailsService(userDetailsService);
		return provider;
	  }
	
	
	
}
