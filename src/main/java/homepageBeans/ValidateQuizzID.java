/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homepageBeans;

import com.quizapp.dat076.model.dao.QuizDAO;
import com.quizapp.dat076.model.entity.Quiz;
import javax.ejb.EJB;

import lombok.Data;

/**
 *
 * @author anton
 */
public class ValidateQuizzID {

    private int id;
    @EJB
    private QuizDAO quizDAO;

    public Boolean validateQuizzId() {

        Quiz Q = quizDAO.findQuizByID(id);

        return Q != null;
    }

}
