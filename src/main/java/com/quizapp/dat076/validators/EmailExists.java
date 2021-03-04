package com.quizapp.dat076.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.ConstraintTarget;
import javax.validation.Payload;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Idk
 * @author Rebecka
 * @see com.quizapp.dat076.validators.EmailExistsValidator
 */
@Constraint(validatedBy = EmailExistsValidator.class)
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface EmailExists {

    String message() default "Email already exists!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    ConstraintTarget validationAppliesTo() default ConstraintTarget.IMPLICIT;
}
