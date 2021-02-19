/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.dao.QuizDAO;
import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.Category;
import com.quizapp.dat076.model.entity.Quiz;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Data;

/**
 *
 * @author Albin
 */
@Data
@Named
@ViewScoped
public class QuizListBackingBean implements Serializable {

    //@EJB
    //private QuizDAO bookShelf;

    private List<Quiz> quizzes;

    @PostConstruct
    private void init() {
        quizzes= new ArrayList<>();
        quizzes.add(new Quiz("hello1", new Account("user_1", "email", "password", null), new Category("General")));
        quizzes.add(new Quiz("hello2", new Account("user_2", "email", "password", null), new Category("Movies")));
        quizzes.add(new Quiz("hello3", new Account("user_3", "email", "password", null), new Category("History")));
    }

}
