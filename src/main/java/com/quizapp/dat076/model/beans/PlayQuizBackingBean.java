/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;


import com.quizapp.dat076.model.dao.QuestionDAO;
import com.quizapp.dat076.model.dao.QuizDAO;
import com.quizapp.dat076.model.entity.Question;
import com.quizapp.dat076.model.entity.Quiz;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;
import org.omnifaces.cdi.Param;
/**
 *
 * @author Anton Blomdell / Albin
 */
@Data
@Named
@ViewScoped
public class PlayQuizBackingBean implements Serializable{
    
    @Inject
    @Param(name = "quizId")
    private int quizId;
    
    @EJB
    private QuizDAO quizDAO;
    @EJB
    private QuestionDAO questionDAO;
    
    private List<Question> questions;
    private Question currentquestion;
    
    
   public List<Question> getQuestions(){
        
     questions =  questionDAO.findQuestionsinQuiz(quizDAO.find(quizId));
     currentquestion = questions.get(0);
        
        return questions;
    }
    public Question getcurrentQuestion(){
        
     questions =  questionDAO.findQuestionsinQuiz(quizDAO.find(quizId));
     currentquestion = questions.get(0);
        
        return currentquestion;
    }
    
}
