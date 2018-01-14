package com.ebanks.springapp.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// TODO: Auto-generated Javadoc
/**
 * The Class EmailValidator.
 */
public class EmailValidator
implements ConstraintValidator<ValidEmail, String> {

  /** The pattern. */
  private Pattern pattern;

  /** The matcher. */
  private Matcher matcher;

  /** The Constant EMAIL_PATTERN. */
  private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";

  /* (non-Javadoc)
   * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
   */
  @Override
  public void initialize(ValidEmail constraintAnnotation) {
  }

  /* (non-Javadoc)
   * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
   */
  @Override
  public boolean isValid(String email, ConstraintValidatorContext context){
      return (validateEmail(email));
  }

  /**
   * Validate email based on regular expression.
   *
   * @param email the email
   * @return true, if successful
   */
  private boolean validateEmail(String email) {
      pattern = Pattern.compile(EMAIL_PATTERN);
      matcher = pattern.matcher(email);
      return matcher.matches();
  }
}
