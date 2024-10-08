package com.ra.security;

import com.ra.security.jwt.CustomAccessDeniedHandler;
import com.ra.security.jwt.JwtAuthTokenFilter;
import com.ra.security.jwt.JwtEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig  {
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private JwtAuthTokenFilter jwtAuthTokenFilter;
    @Autowired
    private JwtEntryPoint jwtEntryPoint;
    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;
    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.
                csrf(AbstractHttpConfigurer::disable).
                authenticationProvider(authenticationProvider()).
                authorizeHttpRequests((auth)->{
                   auth.requestMatchers("/api/v1/auth/**","/api/v1/upload").permitAll();
                   auth.requestMatchers("/api/v1/admin").hasAuthority("ADMIN");
                   auth.requestMatchers("/api/v1/admin/account").hasAuthority("ADMIN");
                   auth.requestMatchers("/api/v1/admin/category,/api/v1/admin/blog").hasAnyAuthority("ADMIN","SUB_ADMIN");
                   auth.anyRequest().authenticated();
                }).sessionManagement((auth)->auth.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).
                exceptionHandling(
                        auth->auth.authenticationEntryPoint(jwtEntryPoint).
                                accessDeniedHandler(customAccessDeniedHandler)
                ).
                addFilterBefore(jwtAuthTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}
