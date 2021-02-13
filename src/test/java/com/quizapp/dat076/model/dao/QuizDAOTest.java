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
 * @author Albin
 */
@RunWith(Arquillian.class)
public class QuizDAOTest {

    
    Account account1 = new Account("user1", "user1@gmail.com", "password1", null);
    Account account2 = new Account("user2", "user2@gmail.com", "password2", null);
    Account account3 = new Account("user3", "user3@gmail.com", "password3", null);
    
    Category c1 = new Category("General Knowledge");
    Category c2 = new Category("Science");
    Category c3 = new Category("Movies");
    
    Quiz first = new Quiz("First quiz", account1, c1);
    Quiz second = new Quiz("Second quiz", account2, c2);
    Quiz third = new Quiz("Third quiz", account3, c3);

    Quiz bonus1 = new Quiz("Bonus quiz", account1, c2);
    Quiz bonus2 = new Quiz("Bonus quiz", account2, c2);
    Quiz bonus3 = new Quiz("Bonus quiz", account3, c1);
    

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(QuizDAO.class, Quiz.class, AccountDAO.class, Account.class, CategoryDAO.class, Category.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private QuizDAO quizDAO;
    @EJB
    private AccountDAO acDAO;
    @EJB
    private CategoryDAO catDAO;
    
    @Before
    public void setUp() {
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
    }
    
    @After
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
    
    //@Test
    /**
     * Checks that the quiz id leads to the correct quiz
     */
    public void testFind_ID(){
        
        Quiz firstQuiz = quizDAO.find(1);
        assert (firstQuiz.getTitle().equals("First quiz"));
        assert (firstQuiz.equals(first));
        
        Quiz secondQuiz = quizDAO.find(2);
        assert (secondQuiz.getTitle().equals("Second quiz"));
        assert (secondQuiz.equals(second));
        
        Quiz bonusQuiz = quizDAO.find(6);
        assert (bonusQuiz.getTitle().equals("Bonus quiz"));
        assert (bonusQuiz.equals(bonus3));
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
    
    @Test
    /**
     * Checks that the correct number of quizzes are returned when filtering by
     * creator, and that the quizzes are correct.
     */
    public void testFindQuizzesByCreator() {

        //Retrieve the quizzes created by account1
        List<Quiz> quizzes = quizDAO.findQuizzesByCreator(account1);
        
        //Check that the number of quizzes created by account1 is 2, and that
        //the quizzes returned are matches what is expected
        assert(quizzes.size() == 2);
        assert(quizzes.get(0).getTitle().equals("First quiz") && quizzes.get(0).getCreator().getUsername().equals("user1"));
        assert(quizzes.get(1).getTitle().equals("Bonus quiz") && quizzes.get(1).getCreator().getUsername().equals("user1"));

    }
    
    @Test
    /**
     * Checks that filtering by category return the expected quizzes
     */
    public void testFindQuizzesByCategory(){
        
        //Retrieve the quizzes with category "General Knowledge"
        List<Quiz> quizzes = quizDAO.findQuizzesByCategory(c1);
        
        assert(quizzes.size() == 2);
        for(Quiz quiz: quizzes){
            assert(quiz.getQuizzCategory().getCategory().equals(c1.getCategory()));
        }
        
        //Retrieve the quizzes with category "Science"
        List<Quiz> quizzes2 = quizDAO.findQuizzesByCategory(c2);
        
        assert(quizzes2.size() == 3);
        for(Quiz quiz: quizzes2){
            assert(quiz.getQuizzCategory().getCategory().equals(c2.getCategory()));
        }
        
    }
    

}
