/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.controller;

import com.quizapp.dat076.model.beans.PlayQuizBackingBean;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;

/**
 * Controller for PlayQuizBackingBean class. Handles the function of going to the next question aswell checking if the correct answer was choosen by the player when playing the quiz.
 * @author Albin
 * @see com.quizapp.dat076.model.beans.PlayQuizBackingBean
 */

@Data
@ViewScoped
@Named
public class PlayQuizController implements Serializable {

    @Inject
    private PlayQuizBackingBean playQuizBackingBean;
    
   
    public void onAnswer(int answerIndex) {

        if (answerIndex == playQuizBackingBean.getCorrectAnswerIndex()) {
            playQuizBackingBean.correctAnswer();
        } else {
            playQuizBackingBean.incorrectAnswer();
        }

    }

    public void nextQuestion() {
        playQuizBackingBean.nextQuestion();
    }
    
    public String redirectRatings(){
    
    return "ratings.xhtml" + "?faces-redirect=true";
    }
    
    public String redirectAccount(){
    
    return "accountpage.xhtml" + "?faces-redirect=true";
    }
    
    public String redirectPlay(){
    
    return "available_quizzes.xhtml" + "?faces-redirect=true";
    }
    public void EndQuiz(){
        
        playQuizBackingBean.isEndQuiz();
      
        try {
            FacesContext.getCurrentInstance()
                    .getExternalContext().redirect("endquiz.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(PlayQuizController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
