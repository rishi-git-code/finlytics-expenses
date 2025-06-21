package com.finlytics.expenses.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private static final String INTERNAL_HEADER = "X-Internal-Key";
    private static final String INTERNAL_SECRET = "super-secret-123";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().authenticated()
//                )
//                .addFilterBefore((request, response, chain) -> {
//                    HttpServletRequest httpRequest = (HttpServletRequest) request;
//                    HttpServletResponse httpResponse = (HttpServletResponse) response;
//                    String header = httpRequest.getHeader(INTERNAL_HEADER);
//                    if (!INTERNAL_SECRET.equals(header)) {
//                        httpResponse.setStatus(401);
//                        httpResponse.getWriter().write("Unauthorized - Invalid Gateway Token");
//                        return;
//                    }
//                    chain.doFilter(request, response);
//                }, UsernamePasswordAuthenticationFilter.class)
//                .httpBasic(Customizer.withDefaults());
//
//        return http.build();
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )
                .httpBasic(httpBasic -> httpBasic.disable())
                .formLogin(form -> form.disable());
        return http.build();
    }
}
