package com.nissum.challenge.users.services.impl;

import com.nissum.challenge.users.dtos.LoginResponseDto;
import com.nissum.challenge.users.dtos.PhoneDto;
import com.nissum.challenge.users.dtos.UserRequestDto;
import com.nissum.challenge.users.dtos.UserResponseDto;
import com.nissum.challenge.users.entities.PhoneEntity;
import com.nissum.challenge.users.entities.UserEntity;
import com.nissum.challenge.users.repository.UserRepository;
import com.nissum.challenge.users.services.AuthenticationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class UserServiceImplTest {

  @Mock
  private UserRepository userRepository;

  @Mock
  private PasswordEncoder passwordEncoder;

  @Mock
  private AuthenticationService authenticationService;

  @InjectMocks
  UserServiceImpl userService;

  @Test
  void createUserTestOk() {

    Mockito.when(passwordEncoder.encode(Mockito.any())).thenReturn("35454435");

    Mockito.when(authenticationService.login(Mockito.any())).thenReturn(dummyLoginRespionse());

    Mockito.when(userRepository.save(Mockito.any()))
        .thenReturn(dummyUserEntity());

    UserResponseDto responseDto = userService.createUser(dummyUserRequestDto());

    Assertions.assertNotNull(responseDto);
  }

  private UserRequestDto dummyUserRequestDto() {
    return UserRequestDto.builder()
        .name("Brayan")
        .email("brayanrondonh@gmail.com")
        .password("asda$Asads")
        .phones(List.of(PhoneDto.builder().build()))
        .build();
  }

  private UserEntity dummyUserEntity() {
    return UserEntity.builder()
        .phones(List.of(PhoneEntity.builder().build()))
        .build();
  }

  private LoginResponseDto dummyLoginRespionse()
  {
    return LoginResponseDto.builder()
        .token("dfgsrgdf-afgdfgfdg-dsfgsdfg-dsfgdfg")
        .build();
  }

}