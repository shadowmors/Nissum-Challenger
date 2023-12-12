package com.nissum.challenge.users.controllers;

import com.nissum.challenge.users.dtos.UserRequestDto;
import com.nissum.challenge.users.dtos.UserResponseDto;
import com.nissum.challenge.users.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "Users", description = "User Managemet APIs")
public class UserController {

  private final UserService userService;

  @PostMapping
  @Operation(summary = "Save and retrieve a user",
      description = "Post a user object. The response is UserResponseDto object with id, name, phones and isActive status.")
  @ApiResponse(responseCode = "200",
      content = { @Content(schema = @Schema(implementation = UserResponseDto.class), mediaType = "application/json") })
  @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) })
  @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
  public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto requestDto) {
    UserResponseDto responseDto = userService.createUser(requestDto);
    return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(responseDto.getId())
            .toUri())
        .body(responseDto);
  }

}