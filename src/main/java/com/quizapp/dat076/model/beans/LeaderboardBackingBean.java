/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.controller.LeaderboardController;
import com.quizapp.dat076.model.dao.LeaderboardDAO;
import com.quizapp.dat076.model.entity.Leaderboard;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.inject.Inject;
import lombok.Data;

/**
 * Backing Bean for leaderboard.xhtml.
 * @author Rebecka
 */
@Data
@Named
@ViewScoped
public class LeaderboardBackingBean implements Serializable {

    private List<Leaderboard> board;

    @EJB
    private LeaderboardDAO leaderboardDAO;

    @Inject
    private LeaderboardController controller;

    @PostConstruct
    public void init() {
        board = leaderboardDAO.findScoresByQuizID(1);
        //board = controller.getAccounts(board,8);
    }

    public List<Leaderboard> getBoard() {
        board.sort((l1, l2)
                -> l2.getScore().compareTo(
                        l1.getScore()));
        return board;
    }

    public void test() {
        System.out.println("BIITCH \n");
        for (Leaderboard x : board) {
            System.out.printf("username: %s , quizid: %d , score: %d \n", x.getAccount().getUsername(), x.getQuiz().getId(), x.getScore());
        }
    }
}
