/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.service.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.Constraint;
import javax.validation.ConstraintTarget;
import javax.validation.Payload;

/**
 *
 * @author anton
 */
@Constraint(validatedBy = PasswordValidator.class)
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface PasswordCorrectFormat {

    String message() default "Password needs to be between 8-48 characters long. Atleast 1 upper case letter. Atleast one lowercase letter. Atleast 1 digit";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    ConstraintTarget validationAppliesTo() default ConstraintTarget.IMPLICIT;
}
