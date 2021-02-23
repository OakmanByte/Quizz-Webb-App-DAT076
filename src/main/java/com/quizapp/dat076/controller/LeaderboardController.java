/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.controller;

import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.Leaderboard;
import com.quizapp.dat076.model.entity.Quiz;
import com.quizapp.dat076.view.LeaderboardBackingBean;
import com.quizzapp.dat076.model.database.dao.key.LeaderboardPK;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
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
    private List<Leaderboard> accounts;
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

    
    @PostConstruct
    public void init(){
        accounts = new ArrayList<>();
       /* accounts.add(new Account("Rebecka","rebecka@me.com","psgjsg",null));
        accounts.add(new Account("Emma","reemma@me.com","psdsgjsg",null));
        accounts.add(new Account("AntonE","antone@me.com","psgsdfjsg",null));
        accounts.add(new Account("AntonB","antonb@me.com","pssegg",null));
        accounts.add(new Account("Emma","rebecka@me.com","psgjsg",null));
        accounts.add(new Account("Albin","albin@me.com","egsge",null));
        accounts.add(new Account("Patrick","Patrick@me.com","pbhear",null));
        accounts.add(new Account("Adam","adam@me.com","sdfbs",null));
        accounts.add(new Account("Matti","matti@me.com","jsdff",null));
        accounts.add(new Account("Robin","Robin@me.com","psdgh",null));
        accounts.add(new Account("Sonic","gottoGoFast@me.com","SEGA",null));
        accounts.add(new Account("Knuckles","punch@me.com","ksry",null));
        accounts.add(new Account("Shadow","darkSonic@me.com","kykuyu",null));
        accounts.add(new Account("Tails","fly@me.com","puyre",null));
        accounts.add(new Account("Amy","mememe@me.com","IloveSonic",null));
        accounts.add(new Account("Robotnick","dr@me.com","notEggman",null));
        accounts.add(new Account("Mario","plumberNo1@me.com","nfds",null));
        accounts.add(new Account("Luigi","plumberNo2@me.com","mvbnv",null));
        accounts.add(new Account("Peach","SaveMe@me.com","dfnvf",null));*/
        
       acc1= new Account("Rebecka","rebecka@me.com","psgjsg",null);
       acc2= new Account("Emma","reemma@me.com","psdsgjsg",null);
       acc3= new Account("AntonE","antone@me.com","psgsdfjsg",null);
       
       quiz1 = new Quiz("Such Amaze", acc1, null);
       quiz2 = new Quiz("Very Much", acc2, null);
       quiz3 = new Quiz("Best Quiz", acc2, null);
       
       quiz1.setCreator(acc1);
       quiz2.setCreator(acc1);
       quiz3.setCreator(acc1);
        
   
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
       
       accounts.add(lead1);
       accounts.add(lead2);
       accounts.add(lead3);
       accounts.add(lead4);
       accounts.add(lead5);
       accounts.add(lead6);
       accounts.add(lead7);
       accounts.add(lead8);
       accounts.add(lead9);

       sortHighest();
    }
    
    
    public List<Leaderboard> getAccounts(int size) {
            if (size > accounts.size()) {
            Random rand = new Random();

            List<Leaderboard> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(accounts.size());
                randomList.add(accounts.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(accounts.subList(0, size));
        }
    }
    
    public void sortHighest(){
         accounts.sort((l1,l2) 
                      -> l2.getScore().compareTo( 
                          l1.getScore())); 
    }
   
    
}
