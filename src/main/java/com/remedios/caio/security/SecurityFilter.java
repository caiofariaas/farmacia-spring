package com.remedios.caio.security;


import com.remedios.caio.repositories.UsuarioRepository;
import com.remedios.caio.security.services.TokenService;
import com.remedios.caio.services.UsuarioService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if(getToken(request) != null){

            var usuario = usuarioService.getByLogin(tokenService.getSubject(getToken(request)));

            SecurityContextHolder
                    .getContext()
                    .setAuthentication(new UsernamePasswordAuthenticationToken(response, null, usuario.getAuthorities()));
        }
        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {

        if (request.getHeader("Authorization") != null){
            return request
                    .getHeader("Authorization")
                    .replace("Bearer ", "");
        }
        return null;
    }
}
