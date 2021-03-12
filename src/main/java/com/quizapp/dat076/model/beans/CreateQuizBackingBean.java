/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.dao.CategoryDAO;
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
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Emma Dirnberger
 */
@Data
@Named("createQuiz")
@ViewScoped
public class CreateQuizBackingBean implements Serializable {

    //Attributes
    @NotNull
    private String title;
    @NotNull
    private Category category;
    private Question question;

    @EJB
    private QuizDAO quizDAO;
    
    @EJB
    private CategoryDAO catDAO;

    @Inject
    private UserBean userBean;

    public void addQuiz() {
        //Correct answer = alt 1 always atm
        Question newQuestion = new Question();
        Quiz quizToCreate = new Quiz(title, userBean.getAccount(), category);
//        quizToCreate.setQuizzCategory(category);
//        quizDAO.update(quizToCreate);
        System.out.println("***** " + quizToCreate.getCreator().getUsername() + " " + category);

        quizDAO.create(quizToCreate);
        System.out.println("***** Quiz created is " + quizDAO.findQuizByID(quizToCreate.getId()));
    }

    public void onItemSelectedListener(SelectEvent event) {
        String catTitle = (String) event.getObject();
        Category selectedItem = catDAO.find(catTitle);
        System.out.println("**** Category is maybe: " + selectedItem);
        category = selectedItem;
    }
}
