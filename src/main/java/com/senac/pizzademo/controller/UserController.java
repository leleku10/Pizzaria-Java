package com.senac.pizzademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.pizzademo.dto.Login;
import com.senac.pizzademo.model.User;
import com.senac.pizzademo.services.TokenService;

@RestController
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;    

    @RequestMapping("/login")
    public String login(@RequestBody Login login){

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login.login(), login.senha());

        Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var usuario = (User) authenticate.getPrincipal();

        return tokenService.gerarToken(usuario);
    }



}
