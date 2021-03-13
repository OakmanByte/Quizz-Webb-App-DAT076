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

    //Quiz quiz1 = new Quiz("Such Amaze", account1, null);
    Quiz quiz1 = new Quiz(1, "Such Amaze", account1, null, null);
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
    public void findratingsByQuizID() {
        List<Ratings> firstquizRatings = ratingsDAO.findratingsByQuizID(1);
        assert (firstquizRatings.get(0).getQuiz().equals(quiz1));
    }

    @Test
    public void findratingsByUsername() {
        List<Ratings> usernameRatings = ratingsDAO.findratingsByUsername(account3.getUsername());
        assert (usernameRatings.size() == 1);
        assert (usernameRatings.get(0).getCreator().getUsername().equals(account3.getUsername()));

    }

    @Test
    public void findHighestRatingScore() {
        int maxScore = ratingsDAO.FindHighestRatingScore(quiz1.getId());
        assert (maxScore == 5);
    }

    @Test
    public void changeRating() {
        String newRatingComment = "First I loved this, but now I think it's crap!";
        rat1.setReview(newRatingComment);
        ratingsDAO.update(rat1);
        assert (rat1.getReview().equals(newRatingComment));
    }
}
