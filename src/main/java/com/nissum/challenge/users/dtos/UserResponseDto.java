package com.nissum.challenge.users.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Setter
@Getter
@ToString
public class UserResponseDto {

  @Schema(name = "id", description = "Identifier for user (UUID)", example = "3c2fad53-83be-417c-a209-90f0c1596d68")
  private String id;

  @Schema(name = "name", description = "Name for user creation", example = "Brayan")
  private String name;

  @Schema(name = "email", description = "Email for user creation", example = "brayanrondonh@gmail.com")
  private String email;

  @Schema(name = "phones", description = "Phones list for user creation")
  private List<PhoneDto> phones;

  @Schema(name = "created", description = "Creation date of user", example = "2023-12-12T22:14:06.24338")
  private LocalDateTime created;

  @Schema(name = "created", description = "Modification date of user", example = "2023-12-12T22:14:06.24338")
  private LocalDateTime modified;

  @Schema(name = "lastLogin", description = "Last login date of user", example = "2023-12-12T22:14:06.24338")
  private LocalDateTime lastLogin;

  @Schema(name = "token", description = "Token for user creation", example = "3c2fad53-83be-857c-a209-89f0c1596d68")
  private String token;

  @Schema(name = "isActive", description = "Status for user creation", example = "true")
  private Boolean isActive;

}
