/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.dao.QuizDAO;
import com.quizapp.dat076.model.entity.Quiz;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;
import org.omnifaces.cdi.Param;

/**
 *
 * @author Albin
 */
@Data
@Named
@ViewScoped
public class QuizPageBackingBean implements Serializable {

    @Inject
    @Param(name = "quizId")
    private int quizId;

    @EJB
    private QuizDAO quizDAO;

    public Quiz getQuiz() {
        return quizDAO.find(quizId);
    }

}
