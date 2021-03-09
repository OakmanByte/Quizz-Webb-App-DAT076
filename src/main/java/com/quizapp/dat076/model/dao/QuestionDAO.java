/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.mysema.query.jpa.impl.JPAQuery;
import com.quizapp.dat076.model.entity.QQuestion;
import com.quizapp.dat076.model.entity.Question;
import com.quizapp.dat076.model.entity.Quiz;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/**
 * A DAO for the question entity. Has a method for retriving all questions in a quizz.
 * @author Anton Ekman
 */
//Make sure correct Datatype in <>
@Stateless
public class QuestionDAO extends AbstractDAO<String, Question> {

    @Getter
    @PersistenceContext(unitName = "QuizApp")
    private EntityManager entityManager;
    private JPAQuery query;
    private QQuestion question = QQuestion.question1;

    public QuestionDAO() {
        super(Question.class);
        query = new JPAQuery(entityManager);
    }

    public List<Question> findQuestionsinQuiz(Quiz quiz) {
        query = new JPAQuery(entityManager);

        return query.from(question).where(question.quiz.eq(quiz)).list(question);

    }

    public int findCorrectAlternativeByQuestion(String queryQuestion) {
        //JPAQuery query = new JPAQuery(entityManager);

        //return query.select(question.answer).where(question.question.eq(queryQuestion)).fetch();
        return 0;
    }

}
