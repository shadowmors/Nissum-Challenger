package com.nissum.challenge.users.config;

import com.nissum.challenge.users.filters.JwtRequestFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

  private final JwtRequestFilter jwtRequestFilter;

  @Bean
  SecurityFilterChain web(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable)
      .authorizeHttpRequests(authorize ->
        authorize.requestMatchers("/api/auth/**").permitAll()
          .requestMatchers("/api/users/**").permitAll()
          .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
          .requestMatchers(AntPathRequestMatcher.antMatcher("/swagger-ui/**")).permitAll()
          .requestMatchers(AntPathRequestMatcher.antMatcher("/swagger-ui.html")).permitAll()
          .requestMatchers(AntPathRequestMatcher.antMatcher("/v3/api-docs/**")).permitAll()
        .anyRequest().authenticated()
      )
      .cors(Customizer.withDefaults())
      .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
      .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
      .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
    return http.build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

}
