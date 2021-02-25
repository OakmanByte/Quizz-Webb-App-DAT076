/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.controller;

import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.Leaderboard;
import com.quizapp.dat076.model.entity.Quiz;
import com.quizapp.dat076.model.beans.LeaderboardBackingBean;
import com.quizapp.dat076.model.dao.AccountDAO;
import com.quizapp.dat076.model.dao.LeaderboardDAO;
import com.quizapp.dat076.model.dao.QuizDAO;
import com.quizzapp.dat076.model.database.dao.key.LeaderboardPK;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;


/**
 *
 * @author Rebecka
 */
@Named
@ApplicationScoped
@Data
public class LeaderboardController implements Serializable {
   // private List<Leaderboard> accounts;
    /*@Inject
    private LeaderboardBackingBean leaderboardBackingBean;*/
    
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
    
    @EJB
    private LeaderboardDAO leaderboardDAO;
    
    @EJB
    private AccountDAO accountDAO;
   
    @EJB
    private QuizDAO quizDAO;
    
    @PostConstruct
    public void init(){
        //OUTCOMMENT TO MAKE PAGE WORK WITHOUT NULLPOINTER EXCEPTION
        
       /*acc1= new Account("Rebecka","rebecka@me.com","psgjsg",null);
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
        
   
       pk1 = new LeaderboardPK(acc1.getUsername(),quiz1.getId());
       pk2 = new LeaderboardPK(acc1.getUsername(),quiz2.getId());
       pk3 = new LeaderboardPK(acc1.getUsername(),quiz3.getId());
       pk4 = new LeaderboardPK(acc2.getUsername(),quiz1.getId());
       pk5 = new LeaderboardPK(acc2.getUsername(),quiz2.getId());
       pk6 = new LeaderboardPK(acc2.getUsername(),quiz3.getId());
       pk7 = new LeaderboardPK(acc3.getUsername(),quiz1.getId());
       pk8 = new LeaderboardPK(acc3.getUsername(),quiz2.getId());
       pk9 = new LeaderboardPK(acc3.getUsername(),quiz3.getId());

       
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
       leaderboardDAO.create(lead9);*/
       
    }
    
    
    public List<Leaderboard> getAccounts(List<Leaderboard> board,int size) {
            if (size > board.size()) {
            Random rand = new Random();

            List<Leaderboard> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(board.size());
                randomList.add(board.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(board.subList(0, size));
        }
    }
    
 
   
    
}
