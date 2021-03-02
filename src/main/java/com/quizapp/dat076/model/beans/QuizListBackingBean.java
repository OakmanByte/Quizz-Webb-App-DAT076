/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.dao.AccountDAO;
import com.quizapp.dat076.model.dao.CategoryDAO;
import com.quizapp.dat076.model.dao.QuizDAO;
import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.Category;
import com.quizapp.dat076.model.entity.Quiz;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.inject.Named;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author Albin
 */
@Data
@Named
@ViewScoped
public class QuizListBackingBean implements Serializable {
    

    
    //Initializing the contents to be added to the database
    Account account1 = new Account("user1", "user1@gmail.com", "password1", "user", "Sweden", 20, null);
    Account account2 = new Account("user2", "user2@gmail.com", "password2", "user","Sweden", 20, null);
    Account account3 = new Account("user3", "user3@gmail.com", "password3", "user","Sweden", 20, null);

    Category c1 = new Category("General Knowledge");
    Category c2 = new Category("Science");
    Category c3 = new Category("Movies");

    Quiz first = new Quiz("First quiz", account1, c1);
    Quiz second = new Quiz("Second quiz", account2, c2);
    Quiz third = new Quiz("Third quiz", account3, c3);

    Quiz bonus1 = new Quiz("Bonus quiz", account1, c2);
    Quiz bonus2 = new Quiz("Bonus quiz", account2, c2);
    Quiz bonus3 = new Quiz("Bonus quiz", account3, c1);

    //Retrieve the beans for the DAO:s
    @EJB
    private AccountDAO acDAO;

    @EJB
    private CategoryDAO catDAO;

    @EJB
    private QuizDAO quizDAO;

    //The list of all quizzes
    private List<Quiz> quizzes;

    @PostConstruct
    private void init() {
        
        acDAO.create(account1);
        acDAO.create(account2);
        acDAO.create(account3);

        catDAO.create(c1);
        catDAO.create(c2);
        catDAO.create(c3);

        quizDAO.create(first);
        quizDAO.create(second);
        quizDAO.create(third);

        quizDAO.create(bonus1);
        quizDAO.create(bonus2);
        quizDAO.create(bonus3);
        
        
        quizzes = quizDAO.findAll();

    }
    
    @PreDestroy
    public void tearDown() {
        quizDAO.remove(first);
        quizDAO.remove(second);
        quizDAO.remove(third);

        quizDAO.remove(bonus1);
        quizDAO.remove(bonus2);
        quizDAO.remove(bonus3);

        acDAO.remove(account1);
        acDAO.remove(account2);
        acDAO.remove(account3);

        catDAO.remove(c1);
        catDAO.remove(c2);
        catDAO.remove(c3);
    }

}
