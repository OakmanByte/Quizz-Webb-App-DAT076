package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.dao.AccountDAO;
import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.validators.EmailExists;
import com.quizapp.dat076.validators.UserExists;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import com.quizapp.dat076.model.Argon2PasswordHashing;
import com.quizapp.dat076.validators.PasswordCorrectFormat;
import com.quizapp.dat076.validators.PasswordValidator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Backing bean for register.xhtml. Handles the registration and creation of a user. 
 * @author Emma
 */
@RequestScoped
@Setter
@Getter
@Named("register")
public class RegisterBackingBean {

    @UserExists
    private String username;
    @Email
    @EmailExists
    private String email;
    @PasswordCorrectFormat
    private String password;
    private String userrole;
    private String favoritecategory;
    @Min(value=1, message = "You have be older than 1 year old")
    @Max(value=130, message = "You really that old? yhee..nah try again")
    private Integer age;
    private byte[] profilePicture;

    @EJB
    private AccountDAO accountDAO;

    @PostConstruct
    public void init() {
        username = "";
        email = "";
        password = "";
        userrole = "user";
        favoritecategory = "";
        age = null;
    }

    /**
     * Creating an Account database entry based on the input data.
     *
     * @return
     */
    public String add() {
        
        Argon2PasswordHashing argon = new Argon2PasswordHashing();
        PasswordValidator passValidator = new PasswordValidator();
        
        Account accountToCreate = new Account(username, email, argon.hashPassword(password), 
                userrole, favoritecategory, age, profilePicture, null);

        if (!userExists()) {
            accountDAO.create(accountToCreate);
            //Resetting the strings for the form
            username = "";
            email = "";
            password = "";
            userrole = "";
            favoritecategory = "";
            age = 0;
        //something for profilepicture
            return "success";
        } else {
            return "unsuccess";
        }

    }

    /**
     * Method to simply make sure no duplicates are attempted in the database
     *
     * @return
     */
    public boolean userExists() {

        return accountDAO.findAccountByEmail(email) != null
                || accountDAO.findAccountByUsername(username) != null;
    }
}
