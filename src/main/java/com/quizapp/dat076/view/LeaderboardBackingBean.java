/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quizapp.dat076.view;

import com.quizapp.dat076.controller.LeaderboardController;
import com.quizapp.dat076.model.entity.Account;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.inject.Inject;
import lombok.Data;


/**
 *
 * @author Rebecka
 */
@Data
@Named
@ViewScoped
public class LeaderboardBackingBean implements Serializable{
    private List<Account> accounts;
    
    @Inject
    private LeaderboardController controller;
    
    @PostConstruct
    public void init(){
       accounts = controller.getAccounts();
       System.out.println(accounts + "OJOJOJ");
    }
    
    public int test (){
        return accounts.size();
    }
    
  /*  public List<Account> getAccounts() {
        return accounts;
    }*/

   /* public void setController(LeaderboardController controller) {
        this.controller = controller;
    }
    */
}
