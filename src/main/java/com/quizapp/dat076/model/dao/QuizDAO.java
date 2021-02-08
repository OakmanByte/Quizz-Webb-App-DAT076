/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.QQuiz;
import com.quizapp.dat076.model.entity.Quiz;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/**
 *
 * @author Albin
 */
@Stateless
public class QuizDAO extends AbstractDAO<Quiz> {
    
    
    @Getter @PersistenceContext(unitName = "QuizApp")
    private EntityManager entityManager;
    private JPAQueryFactory queryFactory;
    private QQuiz quiz = QQuiz.quiz;
    
    public QuizDAO(){
        super(Quiz.class);
        queryFactory = new JPAQueryFactory(entityManager);
    }
    
    public Quiz findQuizByID(int id){
        
        return queryFactory.selectFrom(quiz).where(quiz.id.eq(id)).fetchOne();
        
    }
    
    public List<Quiz>findQuizzesByTitle(String title) {
        
        List<Quiz> quizzes = queryFactory.selectFrom(quiz).where(quiz.title.eq(title)).fetch();
        return quizzes;
        
    }
    
    public List<Quiz> findQuizzesByCreator(Account creator){
        
        List<Quiz> quizzes = queryFactory.selectFrom(quiz).where(quiz.creator.eq(creator)).fetch();
        return quizzes;
        
    }
    
    
    
}
