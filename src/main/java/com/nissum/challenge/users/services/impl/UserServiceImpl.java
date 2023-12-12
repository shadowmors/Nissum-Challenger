package com.nissum.challenge.users.services.impl;

import com.nissum.challenge.users.builder.UserBuilder;
import com.nissum.challenge.users.dtos.LoginRequestDto;
import com.nissum.challenge.users.dtos.LoginResponseDto;
import com.nissum.challenge.users.dtos.UserRequestDto;
import com.nissum.challenge.users.dtos.UserResponseDto;
import com.nissum.challenge.users.entities.UserEntity;
import com.nissum.challenge.users.repository.UserRepository;
import com.nissum.challenge.users.services.AuthenticationService;
import com.nissum.challenge.users.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationService authenticationService;

  @Override
  public UserResponseDto createUser(UserRequestDto requestDto) {
    String unencryptedPassword = requestDto.getPassword();
    requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
    UserEntity entityBD = userRepository.save(UserBuilder.buildUserEntity(requestDto));

    LoginResponseDto loginResponseDto = authenticationService.login(
      LoginRequestDto.builder()
        .user(entityBD.getEmail())
        .password(unencryptedPassword)
      .build()
    );
    entityBD.setToken(loginResponseDto.getToken());

    userRepository.updateUserName(entityBD.getId(), entityBD.getToken());

    return UserBuilder.buildUserResponseDto(entityBD);
  }
}
