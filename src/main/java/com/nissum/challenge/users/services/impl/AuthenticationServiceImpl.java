package com.nissum.challenge.users.services.impl;

import com.nissum.challenge.users.dtos.LoginRequestDto;
import com.nissum.challenge.users.dtos.LoginResponseDto;
import com.nissum.challenge.users.services.AuthenticationService;
import com.nissum.challenge.users.utils.JwtUtilService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

  private final JwtUtilService jwtUtilService;
  private final AuthenticationManager authenticationManager;
  private final UserDetailsService userDetailsService;

  @Override
  public LoginResponseDto login(LoginRequestDto loginRequestDto) {
    log.info("Autenticando al usuario {}", loginRequestDto.getUser());

    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
      loginRequestDto.getUser(),
      loginRequestDto.getPassword()
    ));

    final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDto.getUser());
    final String jwt = jwtUtilService.generateToken(userDetails);

    return LoginResponseDto.builder()
      .token(jwt)
      .build();
  }

}
