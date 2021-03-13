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
import java.util.List;
import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;

/**
 *
 * @author Emma Dirnberger
 */
@RunWith(Arquillian.class)
public class QuestionDAOTest {

    //Dummy data
    Account account1 = new Account("user", "user@gmail.com", "password", "user", "Science", 20, null, null);

    Quiz quiz1 = new Quiz("Such Amaze", account1, null);

    Question q1 = new Question("How many legs does a dog have?", "2", "4", "6", "8", 2, quiz1);
    Question q2 = new Question("How many legs does a duck have?", "2", "4", "6", "8", 1, quiz1);
    Question q3 = new Question("How many legs does a spider have?", "2", "4", "6", "8", 3, quiz1);

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(AccountDAO.class, Account.class, QuizDAO.class, 
                        Category.class, Quiz.class, QuestionDAO.class, Question.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private QuestionDAO questionDAO;
    @EJB
    private AccountDAO accountDAO;
    @EJB
    private QuizDAO quizDAO;

    @Before
    public void setUp() {
        accountDAO.create(account1);
        quizDAO.create(quiz1);

        questionDAO.create(q1);
        questionDAO.create(q2);
        questionDAO.create(q3);

        quiz1.setCreator(account1);

        quizDAO.update(quiz1);
        accountDAO.update(account1);

    }

    @After
    public void tearDown() {
        questionDAO.remove(q1);
        questionDAO.remove(q2);
        questionDAO.remove(q3);

        quizDAO.remove(quiz1);
        accountDAO.remove(account1);
    }

    @Test
    public void findQuestionsInQuiz() {

        List<Question> questionsInQuiz = questionDAO.findQuestionsinQuiz(quiz1);

        assert (questionsInQuiz.size() == 3);
        assert (questionsInQuiz.contains(q1));
    }

}
