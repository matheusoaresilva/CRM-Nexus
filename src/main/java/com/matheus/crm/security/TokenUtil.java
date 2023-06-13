package com.matheus.crm.security;

import java.util.Collections;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenUtil {

    private static final String TOKEN_HEADER = "Bearer ";
    private static final String EMISSOR = "your-token-emissor";
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 86400000; // 24 horas

    public static String generateToken(String username, String role) {
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(username)
                .setIssuer(EMISSOR)
                .setExpiration(expirationDate)
                .claim("role", "ROLE_ADMIN") // Defina a função do usuário aqui
                .signWith(SECRET_KEY)
                .compact();

    }


    public static Authentication decodeToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("Authorization");
            if (jwtToken != null && jwtToken.startsWith(TOKEN_HEADER)) {
                jwtToken = jwtToken.substring(TOKEN_HEADER.length());

                Jws<Claims> jwsClaims = Jwts.parserBuilder()
                        .setSigningKey(SECRET_KEY)
                        .build()
                        .parseClaimsJws(jwtToken);

                String usuario = jwsClaims.getBody().getSubject();
                String emissor = jwsClaims.getBody().getIssuer();
                Date validade = jwsClaims.getBody().getExpiration();

                if (usuario != null && !usuario.isEmpty() && emissor.equals(EMISSOR) && validade.after(new Date())) {
                    Claims claims = jwsClaims.getBody();
                    String username = claims.getSubject();

                    if (username != null) {
                        UserDetails userDetails = User.builder()
                                .username(username)
                                .password("") // Senha vazia, já que não é necessária para autenticação
                                .authorities(Collections.emptyList())
                                .build();
                        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    }


                }

            }
        } catch (Exception e) {
            System.out.println("DEBUG - erro ao decodificar");
            e.printStackTrace();
        }
        return null;
    }


   
}
