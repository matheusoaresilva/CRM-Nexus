package com.matheus.crm.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf().disable()    //desabilita csrf
		.authorizeHttpRequests()  // requisicoes http sao passiveis de autorizacao
		.antMatchers(HttpMethod.POST, "/user/create").permitAll() //especificando quem é liberado
		.anyRequest().authenticated().and().cors(); // todas as outras URLS terao necessidade de autenticacao e sofrerao as restricoes do cors
		
//		http.addFilterBefore(new Filter(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
		
	}
}
