/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.dao.QuizDAO;
import com.quizapp.dat076.model.entity.Category;
import com.quizapp.dat076.model.entity.Question;
import com.quizapp.dat076.model.entity.Quiz;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author Emma Dirnberger
 */
@Data
@Named("createQuiz")
@ViewScoped
public class CreateQuizBackingBean implements Serializable {

    //TODO give randomID or increasing id
    private int id;
    //Attributes
    @NotNull
    private String title;
    private Category quizzCategory;
    private Question question;

    @EJB
    private QuizDAO quizDAO;

    @Inject
    private UserBean userBean;

    public void add() {
        Quiz quizToCreate = new Quiz(id, title, userBean.getAccount(), quizzCategory, null);
        System.out.println("***** " + quizToCreate.getCreator());
    }

}
