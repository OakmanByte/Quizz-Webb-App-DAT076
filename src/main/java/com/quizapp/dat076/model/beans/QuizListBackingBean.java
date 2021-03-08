/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.dao.AccountDAO;
import com.quizapp.dat076.model.dao.CategoryDAO;
import com.quizapp.dat076.model.dao.QuestionDAO;
import com.quizapp.dat076.model.dao.QuizDAO;
import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.Category;
import com.quizapp.dat076.model.entity.Question;
import com.quizapp.dat076.model.entity.Quiz;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.inject.Named;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;

/**
 * Backing Bean for available_quizzes.xhtml
 * @author Albin
 */
@Data
@Named
@ViewScoped
public class QuizListBackingBean implements Serializable {
    
    //Retrieve the beans for the DAO:s
    
    @EJB
    private QuizDAO quizDAO;
    
    //The list of all quizzes
    private List<Quiz> quizzes;
    
    @PostConstruct
    private void init() {
        
        quizzes = quizDAO.findAll();

    }

}
