/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.Category;
import com.quizapp.dat076.model.entity.Quiz;
import java.util.List;
import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Emma Dirnberger
 */
@RunWith(Arquillian.class)
public class AccountDAOTest {
    //Dummy data to test the database
    Account account1 = new Account("user", "user@gmail.com", "password", null);
    Account account2 = new Account("user1", "user1@gmail.com", "password", null);
    Account account3 = new Account("user2", "user2@gmail.com", "password", null);
    
    Quiz quiz1 = new Quiz("Such Amaze", account1, null);
    Quiz quiz2 = new Quiz("Such Amaze", account1, null);
    Quiz quiz3 = new Quiz("Such Amaze", account1, null);

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(AccountDAO.class, Account.class, QuizDAO.class, Quiz.class, Category.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private AccountDAO accountDAO;
    @EJB
    private QuizDAO quizDAO;

    @Before
    public void setUp() {
        accountDAO.create(account1);
        accountDAO.create(account2);
        accountDAO.create(account3);
        
        quizDAO.create(quiz1);
        quizDAO.create(quiz2);
        quizDAO.create(quiz3);
    }
    
    @After
    public void tearDown() {
        quizDAO.remove(quiz1);
        quizDAO.remove(quiz2);
        quizDAO.remove(quiz3); 
        
        accountDAO.remove(account1);
        accountDAO.remove(account2);
        accountDAO.remove(account3);
    }
    
    @Test  
    public void findAccountByEmail() {
        //TODO make this more readable and nicer looking
        Assert.assertTrue(accountDAO.findAccountByEmail(account1.getEmail())
                .getUsername().equals(account1.getUsername()));
    }
    
    @Test   
    public void findAccountByUsername() {
        //TODO make this more readable and nicer looking
        Assert.assertTrue(accountDAO.findAccountByUsername(account1.getUsername())
                .getEmail().equals(account1.getEmail()));
    }
    
    @Test   
    public void updateEmail() {
        String emailTest = "HEJ@gmail.com";
        account1.setEmail(emailTest);
        Assert.assertTrue(account1.getEmail().equals(emailTest));
    }
    
    @Test
    public void checkSizeOfQuizListForAccount() {
        // Is it possible to make so account1.getCreatedQuizzes() isn't empty?
        //int sizeOfQuizList = account1.getCreatedQuizzes().size();
        
        //Retrieve the quizzes created by account1
        List<Quiz> quizzes = quizDAO.findQuizzesByCreator(account1);
        
        //3 quizzes have been added to account1, therefore size should be 3
        Assert.assertTrue(quizzes.size() == 3);
    }
}
