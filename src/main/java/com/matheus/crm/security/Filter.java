package com.matheus.crm.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matheus.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Filter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Autowired
    UserRepository userRepository;


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		System.out.println("DEBUG - passou pelo filtro");

        String token;

        var authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null){
            token = authorizationHeader.replace("Bearer ", "");
            var subject = this.tokenService.getSubject(token);

            var usuario = this.userRepository.findByUsername(subject);

            var authentication = new UsernamePasswordAuthenticationToken(usuario,
                    null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);

//		if (request.getHeader("Authorization") != null) {
//			// aqui vou fixar um negocio massa
//			System.out.println(request.getHeader("Authorization"));
////			Authentication auth = TokenUtil.decodeToken(request);
//			if (auth != null) {
//				// se o meu token for valido eu passo a requisicao pra frente indicando que ela
//				// esta autenticada
//				SecurityContextHolder.getContext().setAuthentication(auth);
//			} else {
//				System.out.println("Erro!");
//				// token existe, mas nao eh valido - preciso customizar a minha mensagem de erro
//				System.out.println("Erro no token");
//				ErroDTO erro = new ErroDTO(401, "Usuario nao autorizado para este sistema");
//				response.setStatus(erro.getStatus());
//				response.setContentType("application/json");
//				ObjectMapper mapper = new ObjectMapper();
//				response.getWriter().print(mapper.writeValueAsString(erro));
//				response.getWriter().flush();
//				return;
//
//			}
//		}
//		filterChain.doFilter(request, response);

	}

}
