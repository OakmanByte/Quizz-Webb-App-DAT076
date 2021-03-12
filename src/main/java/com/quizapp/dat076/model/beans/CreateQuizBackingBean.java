/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.dao.CategoryDAO;
import com.quizapp.dat076.model.dao.QuestionDAO;
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
    private Question newQuizQuestion;
    private String question;
    private String answer;
    private String option1;
    private String option2;
    private String option3;

    @EJB
    private QuizDAO quizDAO; 
    @EJB
    private CategoryDAO catDAO;
    @EJB
    private QuestionDAO questionDAO;

    @Inject
    private UserBean userBean;

    /**
     * Adding a new quiz to the account
     * @return 
     */
    public String addQuiz() {
        Quiz quizToCreate = new Quiz(title, userBean.getAccount(), category);

        quizDAO.create(quizToCreate);
        //Correct answer = alt 1 always atm
        Question newQuestion = new Question(question, answer, option1, option2, option3, 1, quizToCreate);
        questionDAO.create(newQuestion);

        return "success";
    }

    /**
     * Turns the selected option (String) into a Category object
     * @param event 
     */
    public void onItemSelectedListener(SelectEvent event) {
        String catTitle = (String) event.getObject();
        Category selectedItem = catDAO.find(catTitle);
        category = selectedItem;
    }
}
