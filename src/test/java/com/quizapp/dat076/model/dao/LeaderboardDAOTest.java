/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.Category;
import com.quizapp.dat076.model.entity.Leaderboard;
import com.quizapp.dat076.model.entity.Quiz;
import com.quizzapp.dat076.model.database.dao.key.LeaderboardPK;
import java.util.ArrayList;
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
 * @author Rebec
 */
@RunWith(Arquillian.class)
public class LeaderboardDAOTest {
    Account acc1;
    Account acc2;
    Account acc3;
    
    Quiz quiz1;
    Quiz quiz2;
    Quiz quiz3;
    
    LeaderboardPK pk1;
    LeaderboardPK pk2;
    LeaderboardPK pk3;
    LeaderboardPK pk4;
    LeaderboardPK pk5;
    LeaderboardPK pk6;
    LeaderboardPK pk7;
    LeaderboardPK pk8;
    LeaderboardPK pk9;
    
    Leaderboard lead1;
    Leaderboard lead2;
    Leaderboard lead3;
    Leaderboard lead4;
    Leaderboard lead5;
    Leaderboard lead6;
    Leaderboard lead7;
    Leaderboard lead8;
    Leaderboard lead9;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(LeaderboardDAO.class, Category.class, Quiz.class, Account.class,QuizDAO.class, AccountDAO.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    @EJB
    private LeaderboardDAO leaderboardDAO;
    @EJB 
    private AccountDAO accountDAO;
    @EJB
    private QuizDAO quizDAO;

    @Before
    //Initiating and creating here. Quiz has to be created to generate an id.
    public void setUp() {
       acc1= new Account("Rebecka","rebecka@me.com","psgjsg",null);
       acc2= new Account("Emma","reemma@me.com","psdsgjsg",null);
       acc3= new Account("AntonE","antone@me.com","psgsdfjsg",null);
       
       accountDAO.create(acc1);
       accountDAO.create(acc2);
       accountDAO.create(acc3);
       
       quiz1 = new Quiz("Such Amaze", acc1, null);
       quiz2 = new Quiz("Very Much", acc2, null);
       quiz3 = new Quiz("Best Quiz", acc2, null);
       
       quizDAO.create(quiz1);
       quizDAO.create(quiz2);
       quizDAO.create(quiz3);
       
        quiz1.setCreator(acc1);
        quiz2.setCreator(acc1);
        quiz3.setCreator(acc1);
        
        List<Quiz> temp = new ArrayList();
        temp.add(quiz1);
        temp.add(quiz2);
        temp.add(quiz3);
        acc1.setCreatedQuizzes(temp);
        quizDAO.update(quiz1);
        quizDAO.update(quiz2);
        quizDAO.update(quiz3);
        accountDAO.update(acc1);
       
       pk1 = new LeaderboardPK(acc1.getUsername(),quiz1.getId());
       pk2 = new LeaderboardPK(acc1.getUsername(),quiz2.getId());
       pk3 = new LeaderboardPK(acc1.getUsername(),quiz3.getId());
       pk4 = new LeaderboardPK(acc2.getUsername(),quiz1.getId());
       pk5 = new LeaderboardPK(acc2.getUsername(),quiz2.getId());
       pk6 = new LeaderboardPK(acc2.getUsername(),quiz3.getId());
       pk7 = new LeaderboardPK(acc3.getUsername(),quiz1.getId());
       pk8 = new LeaderboardPK(acc3.getUsername(),quiz2.getId());
       pk9 = new LeaderboardPK(acc3.getUsername(),quiz3.getId());
       

        
        quizDAO.update(quiz1);
        accountDAO.update(acc1);
       
       System.out.println("WAZZUP"+pk1.getQuizID());
       
       lead1 = new Leaderboard(pk1,acc1,quiz1,100);
       lead2 = new Leaderboard(pk2,acc1,quiz2,70);
       lead3 = new Leaderboard(pk3,acc1,quiz3,30);
       lead4 = new Leaderboard(pk4,acc2,quiz1,90);
       lead5 = new Leaderboard(pk5,acc2,quiz2,60);
       lead6 = new Leaderboard(pk6,acc2,quiz3,20);
       lead7 = new Leaderboard(pk7,acc3,quiz1,80);
       lead8 = new Leaderboard(pk8,acc3,quiz2,50);
       lead9 = new Leaderboard(pk9,acc3,quiz3,10);
       
       leaderboardDAO.create(lead1);
       leaderboardDAO.create(lead2);
       leaderboardDAO.create(lead3);
       leaderboardDAO.create(lead4);
       leaderboardDAO.create(lead5);
       leaderboardDAO.create(lead6);
       leaderboardDAO.create(lead7);
       leaderboardDAO.create(lead8);
       leaderboardDAO.create(lead9);
    }
    
    @After
    public void tearDown(){
       accountDAO.remove(acc1);
       accountDAO.remove(acc2);
       accountDAO.remove(acc3);
       
       quizDAO.remove(quiz1);
       quizDAO.remove(quiz2);
       quizDAO.remove(quiz3);
       
       leaderboardDAO.remove(lead1);
       leaderboardDAO.remove(lead2);
       leaderboardDAO.remove(lead3);
       leaderboardDAO.remove(lead4);
       leaderboardDAO.remove(lead5);
       leaderboardDAO.remove(lead6);
       leaderboardDAO.remove(lead7);
       leaderboardDAO.remove(lead8);
       leaderboardDAO.remove(lead9);
    }

    @Test
    public void checkNrPlayersbyQuizId() {
       /* Assert.assertTrue(categoryDAO.findCategory("Geography") != null);
        Assert.assertTrue(categoryDAO.findCategory("Math") != null);
        Assert.assertTrue(categoryDAO.findCategory("Music") != null);*/
      
       List<Leaderboard> quizplayers = leaderboardDAO.findScoresByQuizID(quiz1.getId());
       List<Leaderboard> quizplayers2 = leaderboardDAO.findScoresByQuizID(quiz2.getId());
       List<Leaderboard> quizplayers3 = leaderboardDAO.findScoresByQuizID(quiz3.getId());
       Assert.assertTrue(quizplayers.size()==3);
       Assert.assertTrue(quizplayers2.size()==3);
       Assert.assertTrue(quizplayers3.size()==3);
    }
    
}
