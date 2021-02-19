/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.controller;

import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.view.LeaderboardBackingBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;


/**
 *
 * @author Rebecka
 */
@Named
@ApplicationScoped
public class LeaderboardController implements Serializable {
    private List<Account> accounts;
    
    @PostConstruct
    public void init(){
        accounts = new ArrayList<>();
        accounts.add(new Account("Rebecka","rebecka@me.com","psgjsg",null));
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
        accounts.add(new Account("Peach","SaveMe@me.com","dfnvf",null));

    
    }
    
    public List<Account> getAccounts() {
        List<Account> acc = new ArrayList<>(accounts);
        System.out.println(acc + "LALALA");
        return acc;
        
    }
    
    public List<Account> getAccounts(int size) {
            if (size > accounts.size()) {
            Random rand = new Random();

            List<Account> randomList = new ArrayList<>();
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
    /*
    	public List<Account> getClonedProducts(int size) throws CloneNotSupportedException {
		List<Account> results = new ArrayList<>();
		List<Account> originals = getAccounts(size);
		for (Account original : originals) {
			results.add((Account)original.clone());
		}
		return results;
	}*/
    
    
}
