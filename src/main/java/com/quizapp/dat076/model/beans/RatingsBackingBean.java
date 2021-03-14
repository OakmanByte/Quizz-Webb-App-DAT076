/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.dao.AccountDAO;
import com.quizapp.dat076.model.dao.QuizDAO;
import com.quizapp.dat076.model.entity.Ratings;
import com.quizapp.dat076.model.dao.RatingsDAO;
import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.Quiz;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;

/**
 * Backing Bean for ratings.xhtml and ratingsedit.xhtml
 * @author Anton Blomdell
 */
@Data
@Named
@ViewScoped
public class RatingsBackingBean implements Serializable {

    @EJB
    private RatingsDAO ratingsDAO;
    @EJB
    private AccountDAO accountDAO;
    @EJB
    private QuizDAO quizDAO;
    @Inject
    private UserBean userBean;
      @Inject
    private EndQuizBackingBean endBean;
    
      private Ratings selectedRating;
      private int ratingsScore;
    private int ratingsId;
    private String ratingsReview;
    private Account ratingscreator;
    private Quiz ratingquiz;
   
    private Ratings rating;

    public int getScoreRating() {
        return ratingsScore;
    }

    public void setScoreRating(int ratingsScore) {
        this.ratingsScore = ratingsScore;
    }

    public String add() {
        Ratings rating = new Ratings();

        rating.setScore(ratingsScore);
        rating.setReview(ratingsReview);
        rating.setCreator(accountDAO.findAccountByUsername(userBean.getAccount().getUsername()));
        rating.setQuiz(endBean.getQuiz());
        ratingsDAO.create(rating);
        return "success";
    }

    public void update(Ratings rating) {

        rating.setReview(ratingsReview);
        rating.setScore(ratingsScore);
        ratingsDAO.update(rating);
    }

    public void delete(Ratings rating) {
        ratingsDAO.remove(rating);

    }
    
        public Ratings getSelectedRating() {
        return selectedRating;
    }

    public void setSelectedRating(Ratings selectedRating) {
        this.selectedRating = selectedRating;
    }

  
    
   
}
