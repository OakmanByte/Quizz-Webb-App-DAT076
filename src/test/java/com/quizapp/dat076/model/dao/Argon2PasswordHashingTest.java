/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.quizapp.dat076.model.Argon2PasswordHashing;
import java.util.Objects;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test class for Argon2 hashing. Checking hashing and verify method.
 *
 * @author Anton Ekman
 */
@RunWith(Arquillian.class)
public class Argon2PasswordHashingTest {

    private final Argon2PasswordHashing argon = new Argon2PasswordHashing();
    private final String testpassword = "Password123";
    private String testpasswordhash = "";
    private final String testpassword2 = "NotPassword123";
    private String testpasswordhash2 = "";

    @Before
    public void setup() {

        testpasswordhash = argon.hashPassword(testpassword);
        testpasswordhash2 = argon.hashPassword(testpassword2);
    }

    @Test
    public void checkThatArgon2PasswordHashWorks() {
        //Checking if password hash and verify works
        assert (argon.verifyPassword(testpasswordhash, testpassword.toCharArray()));
        //Wrong hash
        Assert.assertFalse(argon.verifyPassword(testpasswordhash2, testpassword.toCharArray()));
        //Wrong password
        Assert.assertFalse(argon.verifyPassword(testpasswordhash, testpassword2.toCharArray()));
        //Diffrent password diffrent hashes
        Assert.assertFalse(Objects.equals(testpasswordhash, testpasswordhash2));
        //Checking null and empty string
        assert (testpasswordhash != null);
        Assert.assertFalse(Objects.equals(testpasswordhash, ""));
    }

}
