package com.nissum.challenge.nissumchallenge.users.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class LoginResponseDto {
  private String token;
}
