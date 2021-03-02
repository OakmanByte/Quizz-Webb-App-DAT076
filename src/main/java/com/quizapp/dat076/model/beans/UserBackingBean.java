package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.dao.AccountDAO;
import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.validators.EmailExists;
import com.quizapp.dat076.validators.UserExists;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Emma Dirnberger
 */
@RequestScoped
@Setter
@Getter
@Named("user")
public class UserBackingBean {

    @UserExists
    private String username;
    @Email @EmailExists
    private String email; 
    private String password;
    private String userrole;
    private String favoritecategory;
    private int age;

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
    }

    /**
     * Creating an Account database entry based on the input data.TODO make a prettier solution
     * @return
     */
    public String add() {
        Account accountToCreate = new Account(username, email, password, userrole, favoritecategory, age,  null);

        if (!userExists()) {
            accountDAO.create(accountToCreate);
            //Resetting the strings for the form
            username = "";
            email = "";
            password = "";
            userrole="";
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
