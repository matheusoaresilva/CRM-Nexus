//package com.matheus.crm.controller;
//
//import com.matheus.crm.dto.LoginDTO;
//import com.matheus.crm.entity.User;
//import com.matheus.crm.security.TokenUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class AuthController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private TokenUtil tokenUtil;
//
//    @PostMapping("/login")
//    public String login(@RequestBody LoginDTO login) {
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                new UsernamePasswordAuthenticationToken(login.username(),
//                        login.password());
//
//        Authentication authenticate = this.authenticationManager
//                .authenticate(usernamePasswordAuthenticationToken);
//
//        var usuario = (User) authenticate.getPrincipal();
//
//        return TokenUtil.generateToken(usuario);
//
//    }
//}
