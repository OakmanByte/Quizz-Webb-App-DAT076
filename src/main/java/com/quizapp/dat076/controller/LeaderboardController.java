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

    public List<Leaderboard> getAccounts(List<Leaderboard> board, int size) {
        if (size > board.size()) {
            Random rand = new Random();

            List<Leaderboard> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(board.size());
                randomList.add(board.get(randomIndex));
            }

            return randomList;
        } else {
            return new ArrayList<>(board.subList(0, size));
        }
    }

}
