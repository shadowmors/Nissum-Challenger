package com.nissum.challenge.nissumchallenge.users.services;


import com.nissum.challenge.nissumchallenge.users.dtos.LoginRequestDto;
import com.nissum.challenge.nissumchallenge.users.dtos.LoginResponseDto;

public interface AuthenticationService {
  LoginResponseDto login(LoginRequestDto loginRequestDto);
}
