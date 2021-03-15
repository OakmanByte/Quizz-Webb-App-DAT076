/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

/**
 *
 * @author Anton
 */
import com.quizapp.dat076.model.dao.QuestionDAO;
import com.quizapp.dat076.model.dao.QuizDAO;
import com.quizapp.dat076.model.dao.RatingsDAO;
import com.quizapp.dat076.model.entity.Quiz;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;
import org.omnifaces.cdi.Param;

@Data
@Named
@ViewScoped
public class EndQuizBackingBean implements Serializable {

    @Inject
    @Param(name = "quizId")
    private int quizId;
    
    @Inject
    @Param(name = "points")
    private int points;

    private Quiz quiz;
    private int maxPoints;
    private String message;

    @EJB
    private QuizDAO quizDAO;
    @EJB
    private QuestionDAO questionDAO;
    @EJB
    private RatingsDAO ratingsDAO;

    @Inject
    private UserBean userBean;

    private boolean disableEndquiz;
    
    /**
     * Initialize the bean by retrieving the quiz
     **/
    @PostConstruct
    private void init() {
        
        quiz = quizDAO.find(quizId);
        
        maxPoints = questionDAO.findQuestionsinQuiz(quiz).size() * 10;
        
        if(points == 0){
            message = "Zero points, just like your IQ!";
        }else{
            message = "Well done!";
        }
        
    }

    public boolean disableButtons() {
        if (userBean.getAccount().getUsername() == null) {
            disableEndquiz = true;
        } else {
            disableEndquiz = false;
        }
        return disableEndquiz;
    }

}
