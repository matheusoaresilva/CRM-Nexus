package com.matheus.crm.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Filter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            
            Authentication authentication = TokenUtil.decodeToken(request);
            if (authentication != null) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                ErroDTO erro = new ErroDTO(401, "Usuário não autorizado para este sistema");
                response.setStatus(erro.getStatus());
                response.setContentType("application/json");
                ObjectMapper mapper = new ObjectMapper();
                response.getWriter().print(mapper.writeValueAsString(erro));
                response.getWriter().flush();
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String authorization = request.getHeader("Authorization");
//        if (authorization != null){
//
//            System.out.println(authorization + "AAAAAAAAAAAAAAAAA");
//            Authentication auth = TokenUtil.decodeToken(request);
//            if (auth != null){
//                SecurityContextHolder.getContext().setAuthentication(auth);
//            }
//            else {
//                System.out.println("Erro!");
//                ErroDTO erro = new ErroDTO(401, "Usuário não autorizado para este sistema");
//                response.setStatus(erro.getStatus());
//                response.setContentType("application/json");
//                ObjectMapper mapper = new ObjectMapper();
//                response.getWriter().print(mapper.writeValueAsString(erro));
//                response.getWriter().flush();
//                return;
//            }
//        }
//
//        filterChain.doFilter(request, response);
//
//    }

