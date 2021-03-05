/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.mysema.query.jpa.impl.JPAQuery;
import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.Category;
import com.quizapp.dat076.model.entity.QQuiz;
import com.quizapp.dat076.model.entity.Quiz;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/**
 * A DAO for the Quiz entity. Has methods for retriving quizzes by either title,id,creator or category.
 * @author Albin
 * @author Anton Blomdell
 */
@Stateless
public class QuizDAO extends AbstractDAO<Integer, Quiz> {

    @Getter
    @PersistenceContext(unitName = "QuizApp")
    private EntityManager entityManager;
    private final QQuiz quiz = QQuiz.quiz;
    private JPAQuery query;

    public QuizDAO() {
        super(Quiz.class);
    }

    public List<Quiz> findQuizzesByTitle(String title) {

        query = new JPAQuery(entityManager);

        return query.from(quiz).where(quiz.title.eq(title)).list(quiz);

    }

    public Quiz findQuizByID(int id) {

        query = new JPAQuery(entityManager);

        return query.from(quiz).where(quiz.id.eq(id)).singleResult(quiz);

    }

    public List<Quiz> findQuizzesByCreator(Account creator) {

        query = new JPAQuery(entityManager);

        return query.from(quiz).where(quiz.creator.eq(creator)).list(quiz);

    }

    public List<Quiz> findQuizzesByCategory(Category category) {
        query = new JPAQuery(entityManager);

        return query.from(quiz).where(quiz.quizzCategory.eq(category)).list(quiz);
    }

    public void removeQuizById(int id) {

        // query.remove(quiz).where(quiz.id.eq(id)).execute();
        /*
        boolean removed;
        Quiz toDelete = queryFactory.selectFrom(quiz).where(quiz.id.eq(id)).fetchOne();
        
       if(toDelete != null){
           remove(toDelete);
           removed = true;
       }else{
           removed = false;
       }
       
       return removed;*/
    }

    /*public void removeAllQuizzesByCreator(Account creator){
        
        queryFactory.delete(quiz).where(quiz.creator.eq(creator)).execute();
        
    }*/
}
