package com.nissum.challenge.nissumchallenge.users.builder;

import com.nissum.challenge.nissumchallenge.users.dtos.PhoneDto;
import com.nissum.challenge.nissumchallenge.users.dtos.UserRequestDto;
import com.nissum.challenge.nissumchallenge.users.dtos.UserResponseDto;
import com.nissum.challenge.nissumchallenge.users.entities.PhoneEntity;
import com.nissum.challenge.nissumchallenge.users.entities.UserEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserBuilder {

  public static UserEntity buildUserEntity(UserRequestDto requestDto) {

    LocalDateTime currentLocalDateTime = LocalDateTime.now();

    UserEntity userEntity = UserEntity.builder()
      .uuid(UUID.randomUUID().toString())
      .name(requestDto.getName())
      .email(requestDto.getEmail())
      .password(requestDto.getPassword())
      .createdDate(currentLocalDateTime)
      .lastLogin(currentLocalDateTime)
      .isActive(Boolean.TRUE)
      .build();

    List<PhoneEntity> phoneEntities = requestDto.getPhones().stream()
      .map(phoneDto -> PhoneEntity.builder()
        .number(phoneDto.getNumber())
        .cityCode(phoneDto.getCityCode())
        .countryCode(phoneDto.getCountryCode())
        .userEntity(userEntity)
        .build())
      .toList();

    userEntity.setPhones(phoneEntities);

    return userEntity;
  }

  public static UserResponseDto buildUserResponseDto(UserEntity userEntity) {
    return UserResponseDto.builder()
      .id(userEntity.getUuid())
      .name(userEntity.getName())
      .email(userEntity.getEmail())
      .phones(userEntity.getPhones().stream()
        .map(phoneEntity -> PhoneDto.builder()
          .id(phoneEntity.getId())
          .number(phoneEntity.getNumber())
          .cityCode(phoneEntity.getCityCode())
          .countryCode(phoneEntity.getCountryCode())
          .build())
        .toList())
      .isActive(userEntity.getIsActive())
      .token(userEntity.getToken())
      .created(userEntity.getCreatedDate())
      .modified(userEntity.getModifiedDate())
      .lastLogin(userEntity.getLastLogin())
      .build();
  }

}
