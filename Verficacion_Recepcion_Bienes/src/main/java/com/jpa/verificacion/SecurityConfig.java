package com.jpa.verificacion;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean 
	public BCryptPasswordEncoder password() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf->csrf.disable())
		.authorizeHttpRequests((auth)->{
			auth.requestMatchers("/bienes").hasRole("Administrador");
			
			auth.anyRequest().authenticated();})
		.formLogin(form-> form.loginPage("/login")
		.permitAll().defaultSuccessUrl("/intranet"));
		
		return http.build();
		
		
		//return null;
	}
}