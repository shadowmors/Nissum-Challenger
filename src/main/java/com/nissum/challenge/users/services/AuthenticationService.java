package com.nissum.challenge.users.services;


import com.nissum.challenge.users.dtos.LoginRequestDto;
import com.nissum.challenge.users.dtos.LoginResponseDto;

public interface AuthenticationService {
  LoginResponseDto login(LoginRequestDto loginRequestDto);
}
