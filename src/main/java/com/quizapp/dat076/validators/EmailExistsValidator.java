package com.quizapp.dat076.validators;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rebec
 */
import com.quizapp.dat076.model.dao.AccountDAO;
import static javax.validation.constraintvalidation.ValidationTarget.ANNOTATED_ELEMENT;
import static javax.validation.constraintvalidation.ValidationTarget.PARAMETERS;
import javax.ejb.EJB;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;

@SupportedValidationTarget({ANNOTATED_ELEMENT, PARAMETERS})
public class EmailExistsValidator implements ConstraintValidator<EmailExists, String> {

    @EJB
    private AccountDAO accountDAO;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        return accountDAO.findAccountByEmail(email) == null;

    }
}
