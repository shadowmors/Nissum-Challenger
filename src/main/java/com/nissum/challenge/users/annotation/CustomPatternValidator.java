package com.nissum.challenge.users.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.env.Environment;

import java.util.regex.Pattern;

@RequiredArgsConstructor
public class CustomPatternValidator implements ConstraintValidator<CustomPattern, String> {

  private String pattern;
  private final Environment environment;

  @Override
  public void initialize(CustomPattern constraintAnnotation) {
    String patternPropertyKey = constraintAnnotation.patternPropertyKey();
    pattern = environment.getProperty(patternPropertyKey);
    if (StringUtils.isEmpty(pattern)) {
      throw new IllegalArgumentException("Pattern not found for property key: " + patternPropertyKey);
    }
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
    return value != null && Pattern.matches(pattern, value);
  }

}
