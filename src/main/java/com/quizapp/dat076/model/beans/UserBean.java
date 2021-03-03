/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.entity.Account;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;
import lombok.Data;

/**
 *
 * @author anton
 */
@Data
@Named
@SessionScoped
public class UserBean implements Serializable {

    private Account account;

    @Inject
    private SecurityContext securityContext;

    public boolean isAdmin() {

        return securityContext.isCallerInRole("admin");
    }

    public boolean isUser() {

        return account.getUsername() != null;
    }

    @PostConstruct
    private void init() {

        account = new Account();

    }

}
