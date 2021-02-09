/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.mysema.query.jpa.impl.JPAQuery;
import com.quizapp.dat076.model.entity.QQuestion;
import com.quizapp.dat076.model.entity.Question;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/**
 *
 * @author anton
 */
@Stateless
public class QuestionDAO extends AbstractDAO<String,Question>{
    
 @Getter
    @PersistenceContext(unitName = "QuizApp")
    private EntityManager entityManager;
    private JPAQuery query;
    private QQuestion question = QQuestion.question1;

    public QuestionDAO() {
        super(Question.class);
        query = new JPAQuery(entityManager);
    }

}
