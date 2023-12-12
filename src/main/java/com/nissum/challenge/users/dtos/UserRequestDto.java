package com.nissum.challenge.users.dtos;

import com.nissum.challenge.users.annotation.CustomPattern;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@Setter
@Getter
@ToString
public class UserRequestDto {

  @NotBlank(message = "El campo name no debe ir vacio")
  @Schema(name = "name", description = "Name for user creation", example = "Brayan")
  private String name;

  @CustomPattern(patternPropertyKey = "validations-dto.user-request.email-format", message = "El formato del correo electrónico no es válido")
  @Schema(name = "email", description = "Email for user creation", example = "brayanrondonh@gmail.com")
  private String email;

  @CustomPattern(patternPropertyKey = "validations-dto.user-request.password-format", message = "La contraseña debe tener por lo menos una mayúscula y un caracter especial")
  @CustomPattern(patternPropertyKey = "validations-dto.user-request.password-min-size", message = "La contraseña debe tener al menos 8 caracteres")
  @Schema(name = "password", description = "Password for user creation", example = "Admin$2023")
  private String password;

  @Schema(name = "phones", description = "Phones list for user creation")
  private List<PhoneDto> phones;
}
