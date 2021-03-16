package com.quizapp.dat076.service.validator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * A validator class for checking if an username already exists. Used for registrations.
 * @author Emma Dirnberger
 */
import com.quizapp.dat076.model.dao.AccountDAO;
import static javax.validation.constraintvalidation.ValidationTarget.ANNOTATED_ELEMENT;
import static javax.validation.constraintvalidation.ValidationTarget.PARAMETERS;
import javax.ejb.EJB;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;

@SupportedValidationTarget({ANNOTATED_ELEMENT, PARAMETERS})
public class UserExistsValidator implements ConstraintValidator<UserExists, String> {

    @EJB
    private AccountDAO accountDAO;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {

        return accountDAO.findAccountByUsername(username) == null;

    }
}
