package com.inventario.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        
        System.out.println("=== JWT FILTER EJECUTANDOSE ===");
        System.out.println("URI: " + request.getRequestURI());
        
        final String authHeader = request.getHeader("Authorization");
        System.out.println("Authorization Header: " + authHeader);
        
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            System.out.println("Token recibido: " + token.substring(0, Math.min(token.length(), 20)) + "...");
            
            try {
                if (jwtUtil.validateToken(token)) {
                    String email = jwtUtil.extractEmail(token);
                    String rol = jwtUtil.extractRol(token);
                    Integer idUsuario = jwtUtil.extractIdUsuario(token);
                    
                    System.out.println("Email: " + email + ", Rol: " + rol);
                    
                    request.setAttribute("idUsuario", idUsuario);
                    
                    UserDetails userDetails = User.withUsername(email)
                        .password("")
                        .authorities("ROLE_" + rol)
                        .build();
                    
                    UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    System.out.println("Autenticacion exitosa");
                } else {
                    System.out.println("Token invalido");
                }
            } catch (Exception e) {
                System.out.println("Error procesando token: " + e.getMessage());
            }
        } else {
            System.out.println("No hay token Bearer");
        }
        
        chain.doFilter(request, response);
    }
    
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        boolean shouldNotFilter = path.equals("/api/auth/login");
        if (shouldNotFilter) {
            System.out.println("Saltando filtro para login: " + path);
        }
        return shouldNotFilter;
    }
}