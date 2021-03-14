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
    private String question1Text;
    private String answerQuestion1;
    private String option1Question1;
    private String option2Question1;
    private String option3Question1;
    private String question2Text;
    private String answerQuestion2;
    private String option1Question2;
    private String option2Question2;
    private String option3Question2;

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
     *
     * @return
     */
    public String addQuiz() {
        Quiz quizToCreate = new Quiz(title, userBean.getAccount(), category);

        quizDAO.create(quizToCreate);
        //Correct answer = alt 1 always atm
        Question question1 = new Question(question1Text, answerQuestion1, option1Question1,
                option2Question1, option3Question1, 1, quizToCreate);
        Question question2 = new Question(question2Text, answerQuestion2, option1Question2,
                option2Question2, option3Question2, 1, quizToCreate);
        questionDAO.create(question1);
        questionDAO.create(question2);

        return "success";
    }

    /**
     * Turns the selected option (String) into a Category object
     *
     * @param event
     */
    public void onItemSelectedListener(SelectEvent event) {
        String catTitle = (String) event.getObject();
        Category selectedItem = catDAO.find(catTitle);
        category = selectedItem;
    }
}
