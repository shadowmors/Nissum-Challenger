package com.nissum.challenge.users.services;

import com.nissum.challenge.users.dtos.UserRequestDto;
import com.nissum.challenge.users.dtos.UserResponseDto;

public interface UserService {

  UserResponseDto createUser(UserRequestDto requestDto);

}
