/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.Car;
import com.quizapp.dat076.model.entity.Quiz;
import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Albin
 */
@RunWith(Arquillian.class)
public class QuizDAOTest {
    
@Deployment 
public static WebArchive createDeployment() {
    return ShrinkWrap.create(WebArchive.class)
            .addClasses(QuizDAO.class, Quiz.class)
            .addAsResource("META-INF/persistence.xml")
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
}

@EJB
private QuizDAO quizDAO;

@Before
public void init() {
    
    /*Account ac1 = new Account("admin1", "admin1@gmail.com", "password1");
    Account ac2 = new Account("admin2", "admin2@gmail.com", "password2");
    Account ac3 = new Account("admin3", "admin3@gmail.com", "password3");*/
            
    
    quizDAO.create(new Quiz("First quiz"));
    quizDAO.create(new Quiz("Second quiz"));
    quizDAO.create(new Quiz("Third quiz"));
    
}

@Test
public void testTrue() {
    Assert.assertTrue(true); /* Some better condition */
    assert quizDAO != null;
    System.out.println("HERE!");
    System.out.println(quizDAO.findQuizzesByTitle("First quiz").toString());
    Assert.assertTrue(quizDAO.findQuizzesByTitle("First quiz") != null);
}
    
}
