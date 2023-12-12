package com.nissum.challenge.nissumchallenge.users.services.impl;


import com.nissum.challenge.nissumchallenge.users.dtos.UserRequestDto;
import com.nissum.challenge.nissumchallenge.users.dtos.UserResponseDto;

import com.nissum.challenge.nissumchallenge.users.repository.UserRepository;

import com.nissum.challenge.nissumchallenge.users.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;


  @Override
  public UserResponseDto createUser(UserRequestDto requestDto) {
    return null;
  }
}
