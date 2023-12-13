package com.nissum.challenge.users.controllers;

import com.nissum.challenge.users.dtos.PhoneDto;
import com.nissum.challenge.users.dtos.UserResponseDto;
import com.nissum.challenge.users.services.UserService;
import com.nissum.challenge.users.utils.JwtUtilService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@WebMvcTest(UserController.class)
class UserControllerTest {

  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private JwtUtilService jwtUtilService;

  @MockBean
  private UserService userService;


  @Test
  void createUserTestOk() throws Exception {
    Mockito.when(userService.createUser(Mockito.any()))
        .thenReturn(getDummyUserResponseDto());

    mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(getRequestCreateDtoStringDummy()))
        .andExpect(MockMvcResultMatchers.status().is(403));
  }

  private UserResponseDto getDummyUserResponseDto() {
    return UserResponseDto.builder()
        .id("sdgagsdgs")
        .name("Brayan")
        .email("brayanrondonh@gmail.com")
        .isActive(Boolean.TRUE)
        .phones(List.of(PhoneDto.builder()
            .id(1)
            .number("965456765")
            .cityCode("1")
                .countryCode("51")
            .build()))
        .build();
  }

  private String getRequestCreateDtoStringDummy() {
    return "{\n" +
        "    \"name\": \"Brayan\",\n" +
        "    \"email\": \"brayanrondonh@gmail.com\",\n" +
        "    \"password\": \"Ho$a2023\",\n" +
        "    \"phones\": [\n" +
        "        {\n" +
        "            \"number\": \"965456765\",\n" +
        "            \"cityCode\": \"1\",\n" +
        "            \"countryCode\": \"51\"\n" +
        "        }\n" +
        "    ]\n" +
        "}";
  }

}