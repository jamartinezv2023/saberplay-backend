package com.saberplay.config.security;

import com.saberplay.modules.auth.infrastructure.adapters.out.security.JwtService;
import com.saberplay.shared.infrastructure.TenantContext;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String authHeader = request.getHeader("Authorization");
        
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            try {
                Claims claims = jwtService.extractAllClaims(token);
                String username = claims.getSubject();
                String tenantId = (String) claims.get("tenantId");

                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    // Seteamos el TenantContext para el aislamiento de datos (Multitenancy)
                    TenantContext.setTenantId(tenantId);
                    
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            username, null, new ArrayList<>()
                    );
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            } catch (Exception e) {
                // Token inválido o expirado
                SecurityContextHolder.clearContext();
            }
        }
        
        try {
            filterChain.doFilter(request, response);
        } finally {
            // Limpiamos el contexto al terminar la petición para evitar fugas de datos
            TenantContext.clear();
        }
    }
}
