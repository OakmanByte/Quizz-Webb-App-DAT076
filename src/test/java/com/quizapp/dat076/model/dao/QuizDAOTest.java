/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.quizapp.dat076.model.entity.Account;
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
 * @author Albin
 */
@RunWith(Arquillian.class)
public class QuizDAOTest {

    Quiz first = new Quiz("First quiz");
    Quiz second = new Quiz("Second quiz");
    Quiz third = new Quiz("Third quiz");

    Quiz bonus1 = new Quiz("Bonus quiz");
    Quiz bonus2 = new Quiz("Bonus quiz");
    Quiz bonus3 = new Quiz("Bonus quiz");

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
    public void setUp() {
        quizDAO.create(first);
        quizDAO.create(second);
        quizDAO.create(third);
        
        quizDAO.create(bonus1);
        quizDAO.create(bonus2);
        quizDAO.create(bonus3);
    }
    
    @After
    public void tearDown() {
        quizDAO.remove(first);
        quizDAO.remove(second);
        quizDAO.remove(third);
        
        quizDAO.remove(bonus1);
        quizDAO.remove(bonus2);
        quizDAO.remove(bonus3);
    }

    /*@Test
    public void testTrue() {
        Assert.assertTrue(true);
        assert quizDAO != null;
        System.out.println("HERE!");
        //System.out.println(quizDAO.findQuizzesByTitle("First quiz").toString());
        //Assert.assertTrue(quizDAO.findQuizzesByTitle("First quiz") != null);
    }*/
    
    
    @Test
    /**
     * Checks that the quiz id leads to the correct quiz
     */
    public void testFind_ID(){
        
        Quiz firstQuiz = quizDAO.find(1);
        assert (firstQuiz.getTitle().equals("First quiz"));
        assert (firstQuiz.equals(first));
        
        Quiz thirdQuiz = quizDAO.find(3);
        assert (thirdQuiz.getTitle().equals("Third quiz"));
        assert (thirdQuiz.equals(third));
        
        Quiz bonusQuiz = quizDAO.find(5);
        assert (bonusQuiz.getTitle().equals("Bonus quiz"));
        assert (bonusQuiz.equals(bonus2));
    }
    
    
    @Test
    /**
     * Checks that only one quiz is returned by findQuizByTitle() when the title
     * is unique. Also check that the title of the returned quiz matches the
     * search
     */
    public void testFindQuizByTitle_OneQuiz() {

        //Assert that there is only one quiz by name "First quiz"
        List<Quiz> firstQuiz = quizDAO.findQuizzesByTitle("First quiz");
        assert (firstQuiz.size() == 1);
        assert (firstQuiz.get(0).getTitle().equals("First quiz"));

        //Assert that there is only one quiz by name "Second quiz"
        List<Quiz> secondQuiz = quizDAO.findQuizzesByTitle("Second quiz");
        assert (secondQuiz.size() == 1);
        assert (secondQuiz.get(0).getTitle().equals("Second quiz"));

        //Assert that there is only one quiz by name "Third quiz"
        List<Quiz> thirdQuiz = quizDAO.findQuizzesByTitle("Third quiz");
        assert (thirdQuiz.size() == 1);
        assert (thirdQuiz.get(0).getTitle().equals("Third quiz"));

    }

    @Test
    /**
     * Checks that several quizzes are returned by findQuizByTitle() if there
     * are several quizzes sharing the same title. Also check that the number of
     * quizzes returned are the same as the number of quizzes with the given
     * name, and that their titles match the search parameter.
     */
    public void testFindQuizByTitle_MultipleQuizzes() {

        //Assert that there are three quizzes by the name of "Bonus quiz"
        List<Quiz> bonus = quizDAO.findQuizzesByTitle("Bonus quiz");
        assert (bonus.size() == 3);

        //Loop through the returned quizzes and check that the title matches
        for (Quiz quiz : bonus) {
            assert (quiz.getTitle().equals("Bonus quiz"));
        }

    }

}
