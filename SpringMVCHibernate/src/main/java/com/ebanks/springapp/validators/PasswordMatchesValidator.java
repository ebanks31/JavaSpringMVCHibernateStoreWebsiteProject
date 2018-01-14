package com.ebanks.springapp.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ebanks.springapp.model.User;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

  @Override
  public void initialize(PasswordMatches constraintAnnotation) {
  }
  @Override
  public boolean isValid(Object obj, ConstraintValidatorContext context){
      User user = (User) obj;
      return user.getPassword().equals(user.getMatchingPassword());
  }
}