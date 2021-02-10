/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.quizapp.dat076.model.entity.Account;
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
    Account test = new Account("user", "user@gmail.com", "password");
    Account test1 = new Account("user1", "user1@gmail.com", "password");
    Account test2 = new Account("user2", "user2@gmail.com", "password");

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(AccountDAO.class, Account.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private AccountDAO accountDAO;

    @Before
    public void setUp() {
        accountDAO.create(test);
        accountDAO.create(test1);
        accountDAO.create(test2);
    }
    
    @After
    public void tearDown() {
        accountDAO.remove(test);
        accountDAO.remove(test1);
        accountDAO.remove(test2);
    }
    
    @Test   
    public void searchUserNotNull() {
        //TODO
    }
    
    @Test  
    public void findAccountByEmail() {
        //TODO make this more readable and nicer looking
        Assert.assertTrue(accountDAO.findByEmail(test.getEmail()).getUsername().equals(test.getUsername()));
    }
    
    @Test   
    public void findAccountByUsername() {
        //TODO make this more readable and nicer looking
        Assert.assertTrue(accountDAO.findByUsername(test.getUsername()).getEmail().equals(test.getEmail()));
    }
    
    @Test   
    public void updateEmail() {
        //TODO
        test.setEmail("HEJ@gmail.com");
        Assert.assertTrue(test.getEmail().equals("HEJ@gmail.com"));
    }
}
