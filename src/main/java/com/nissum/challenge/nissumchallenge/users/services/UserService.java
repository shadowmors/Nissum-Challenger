package com.nissum.challenge.nissumchallenge.users.services;


import com.nissum.challenge.nissumchallenge.users.dtos.UserRequestDto;
import com.nissum.challenge.nissumchallenge.users.dtos.UserResponseDto;

public interface UserService {

  UserResponseDto createUser(UserRequestDto requestDto);

}
