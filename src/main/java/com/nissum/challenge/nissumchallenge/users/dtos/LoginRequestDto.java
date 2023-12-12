package com.nissum.challenge.nissumchallenge.users.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class LoginRequestDto {
  private String user;
  private String password;
}
