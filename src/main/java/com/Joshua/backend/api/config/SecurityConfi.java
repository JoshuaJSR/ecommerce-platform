package com.Joshua.backend.api.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfi {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity https) throws Exception{
        https.sessionManagement(session->session.
                sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ).csrf(csrf -> csrf.disable())
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        return https.build();
    }

}
