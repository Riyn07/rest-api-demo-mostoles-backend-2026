package com.example.spring_security_jwt.security;


import com.example.spring_security_jwt.security.jwt.AuthEntryPointJwt;
import com.example.spring_security_jwt.security.jwt.AuthTokenFilter;
import com.example.spring_security_jwt.security.jwt.JwtUtils;
import com.example.spring_security_jwt.security.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Configuration
@EnableMethodSecurity
/*
 * La anotación @EnableMethodSecurity permite habilitar la seguridad a nivel de método en Spring Security,
 * Esto significa que se pueden aplicar restricciones de seguridad directamente a los métodos de los controladores o servicios,
 * utilizando anotaciones como @PreAuthorize, @PostAuthorize, @Secured, entre otras. Al habilitar esta funcionalidad,
 * se puede controlar el acceso a los métodos según roles, permisos u otras condiciones definidas en la lógica de seguridad de la aplicación.
 */

@RequiredArgsConstructor
public class WebSecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;
    private final AuthEntryPointJwt unauthorizedHandler;
    private final JwtUtils jwtUtils;

    @Bean
    AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter(jwtUtils, userDetailsService);
    }
}


