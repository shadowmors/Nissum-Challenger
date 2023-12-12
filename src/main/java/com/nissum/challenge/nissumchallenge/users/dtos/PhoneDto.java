package com.nissum.challenge.nissumchallenge.users.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class PhoneDto {

  @Schema(name = "id", description = "Identifier for phone creation", example = "1")
  private Integer id;

  @Schema(name = "number", description = "Number of cellphone", example = "999342542")
  private String number;

  @Schema(name = "cityCode", description = "City code number", example = "200")
  private String cityCode;

  @Schema(name = "cityCode", description = "Country code number", example = "+51")
  private String countryCode;


}
