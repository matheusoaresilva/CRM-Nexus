package com.matheus.crm.security;

import com.matheus.crm.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FilterToken extends OncePerRequestFilter {


    @Autowired
    TokensService tokenService;


    @Autowired
    UserRepository userRepository;


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		System.out.println("DEBUG - passou pelo filtro");

        String token;

        var authorizationHeader = request.getHeader("Authorization");

        System.out.println("DEBUG - passou pelo AUTHORIZATION");

        if (authorizationHeader == null){
            System.out.println("DEBUG - ENTROU NO HEADER");
            token = authorizationHeader.replace("Bearer ", "");
            var subject = this.tokenService.getSubject(token);

            var usuario = this.userRepository.findByUsername(subject);

            var authentication = new UsernamePasswordAuthenticationToken(usuario,
                    null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        System.out.println("DEBUG - passou pelo FILTERCHAIN");
        filterChain.doFilter(request, response);

	}

}
