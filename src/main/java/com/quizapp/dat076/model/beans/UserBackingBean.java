package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.Argon2PasswordHashing;
import com.quizapp.dat076.model.dao.AccountDAO;
import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.validators.EmailExists;
import com.quizapp.dat076.validators.UserExists;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import com.quizapp.dat076.model.Argon2PasswordHashing;

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
@Named("user")
public class UserBackingBean {

    @UserExists
    private String username;
    @Email
    @EmailExists
    private String email;
    @Size(min = 6, max = 12, message
            = "Password must be between 6 and 12 characters")
    private String password;
    private String userrole;
    private String favoritecategory;
    private int age;
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
        age = 0;
        //something for profilepicture
    }

    /**
     * Creating an Account database entry based on the input data.
     *
     * @return
     */
    public String add() {
        
        Argon2PasswordHashing argon = new Argon2PasswordHashing();
        
        Account accountToCreate = new Account(username, email, argon.hashPassword(password), userrole, favoritecategory, age, profilePicture, null);

        if (!userExists()) {
            accountDAO.create(accountToCreate);
            //Resetting the strings for the form
            username = "";
            email = "";
            password = "";
            userrole = "";
            favoritecategory = "";
            age = 0;
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
