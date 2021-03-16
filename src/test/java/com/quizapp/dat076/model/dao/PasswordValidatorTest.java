/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.quizapp.dat076.service.validator.PasswordValidator;
import javax.inject.Inject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author anton
 */

public class PasswordValidatorTest {
     
     private PasswordValidator passwordValidator;

     
     @Before
     public void init(){
     
     passwordValidator = new PasswordValidator();
     }

    @Test
    public void checkThatPasswordValidatorWorks() {
        //less then 8 characters
        Assert.assertFalse(passwordValidator.isValid("aaa",null));
        //Too many characters
        Assert.assertFalse(passwordValidator.isValid("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",null));
        //no number
        Assert.assertFalse(passwordValidator.isValid("aaaaaaAAA%",null));
        //No lowercase
        Assert.assertFalse(passwordValidator.isValid("AAAAA&&542",null));
        //No uppercase
        Assert.assertFalse(passwordValidator.isValid("dawkdo56%&&",null));
        //Should work
        Assert.assertTrue(passwordValidator.isValid("tÄo45&&kdko",null));
        //Should work
        Assert.assertTrue(passwordValidator.isValid("ååååAAA%&78",null));
    }
    
}

