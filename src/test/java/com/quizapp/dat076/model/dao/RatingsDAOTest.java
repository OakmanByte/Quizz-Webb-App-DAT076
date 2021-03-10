/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.Category;
import com.quizapp.dat076.model.entity.Question;
import com.quizapp.dat076.model.entity.Quiz;
import com.quizapp.dat076.model.entity.Ratings;
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
public class RatingsDAOTest {

    //Dummy data
    Account account1 = new Account("user", "user@gmail.com", "password", "user", "Science", 20, null, null);
    Account account2 = new Account("user2", "user2@gmail.com", "password", "user", "Science", 20, null, null);
    Account account3 = new Account("user3", "user3@gmail.com", "password", "user", "Science", 20, null, null);
    Account account4 = new Account("user4", "user4@gmail.com", "password", "user", "Science", 20, null, null);

    Quiz quiz1 = new Quiz("Such Amaze", account1, null);
    Ratings rat1 = new Ratings(5, "Wow this is the best ever! I am so mother puffing impressed", account1, quiz1);
    Ratings rat2 = new Ratings(1, "Wtf who doesn't know how many legs these animals have?", account2, quiz1);
    Ratings rat3 = new Ratings(4, "Wow this was the most difficult ever!", account3, quiz1);

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(AccountDAO.class, Account.class, QuizDAO.class, Category.class,
                        Quiz.class, QuestionDAO.class, Question.class, RatingsDAO.class, Ratings.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    RatingsDAO ratingsDAO;
    @EJB
    private AccountDAO accountDAO;
    @EJB
    private QuizDAO quizDAO;

    @Before
    public void setUp() {
        
        accountDAO.create(account1);
        accountDAO.create(account2);
        accountDAO.create(account3);
        accountDAO.create(account4);
        quizDAO.create(quiz1);

        quiz1.setCreator(account1);

        quizDAO.update(quiz1);
        accountDAO.update(account1);

        ratingsDAO.create(rat1);
        ratingsDAO.create(rat2);
        ratingsDAO.create(rat3);
    }

    @After
    public void tearDown() {
        ratingsDAO.remove(rat1);
        ratingsDAO.remove(rat2);
        ratingsDAO.remove(rat3);
        quizDAO.remove(quiz1);
        accountDAO.remove(account1);
        accountDAO.remove(account2);
        accountDAO.remove(account3);
        accountDAO.remove(account4);
    }

    @Test
    public void truetest() {
        Assert.assertTrue(true);
    }

    @Test
    public void findAllRatings() {
        List<Ratings> ratings = ratingsDAO.findAllRatings();
        Assert.assertTrue(ratings.size() == 3);
    }
    // TODO fix addRating or remove
//    @Test
//    public void addNewRatings() {
//        Ratings newrat = new Ratings(3, "This was ok", account4, quiz1);
//        ratingsDAO.addRating(newrat);
//
//        List<Ratings> ratings = ratingsDAO.findAllRatings();
//        Assert.assertTrue(ratings.size() == 4);
//    }
    
    @Test
    public void findHighestScore() {
        int highestScore = ratingsDAO.FindHighestScore();
        
        Assert.assertTrue(highestScore == 5);
    }
}
