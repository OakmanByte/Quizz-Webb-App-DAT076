/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.dao.AccountDAO;
import com.quizapp.dat076.model.dao.CategoryDAO;
import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.Category;
import homepageBeans.LoginViewBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.xml.registry.infomodel.User;
import lombok.Data;

/**
 *
 * @author anton
 */
@Data
@Named
@ViewScoped
public class AccountSettingsBackingBean implements Serializable  {
    
    private List<String> correctcategories = new ArrayList<>();
    private List<Category> wrongCategories= new ArrayList<>();
    
    Category c1 = new Category("General Knowledge");
    Category c2 = new Category("Science");
    Category c3 = new Category("Movies");
    
    
    @EJB
    private CategoryDAO categoryDAO;
    
    @EJB
    private AccountDAO accountDAO;
    
     @PostConstruct
    public void init() {
        
    categoryDAO.create(c1);
    categoryDAO.create(c2);
    categoryDAO.create(c3);
    
    wrongCategories.addAll(categoryDAO.findAll());
    
    for(int i = 0; i< wrongCategories.size(); i++){
    
        correctcategories.add(wrongCategories.get(i).getCategory());
    
    }
        
    }
    
    
    public void updateAgeandFavoriteQuizz(){
    
        //UserBackingBean.getUsername();
        
        
    //Account acc =  accountDAO.findAccountByUsername(LoginViewBean.getUsername());
     
    
    }
    
}
