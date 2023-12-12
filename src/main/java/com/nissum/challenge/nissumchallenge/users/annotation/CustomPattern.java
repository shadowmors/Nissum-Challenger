package com.nissum.challenge.nissumchallenge.users.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(CustomPattern.List.class)
@Constraint(validatedBy = CustomPatternValidator.class)
@Documented
public @interface CustomPattern {

  String message() default "Invalid value";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String patternPropertyKey();

  Pattern.Flag[] flags() default {};

  @Target({ElementType.FIELD, ElementType.PARAMETER})
  @Retention(RetentionPolicy.RUNTIME)
  @Documented
  @interface List {
    CustomPattern[] value();
  }
}
