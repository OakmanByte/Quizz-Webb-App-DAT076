/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.validators;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import static javax.validation.constraintvalidation.ValidationTarget.ANNOTATED_ELEMENT;
import static javax.validation.constraintvalidation.ValidationTarget.PARAMETERS;

/**
 *
 * @author anton
 */
@SupportedValidationTarget({ANNOTATED_ELEMENT, PARAMETERS})
public class PasswordValidator implements ConstraintValidator<PasswordCorrectFormat, String>{
 
    private final Pattern pattern;
    private Matcher matcher;
 
    //Password between 8-48 characters, atleast 1 lowercase and 1 Uppercase, atleast 1 number
    private static final String password_regex = "^(?=.*[0-9])"
                                                    + "(?=.*[a-zåäö])(?=.*[A-ZÅÄÖ])"
                                                    + "(?=\\S+$).{8,20}$"; 
 
    public PasswordValidator() {
        pattern = Pattern.compile(password_regex);
    }
 
    @Override
    public boolean isValid(final String password,ConstraintValidatorContext context) {
 
        matcher = pattern.matcher(password);
        return matcher.matches();
 
    }
}
