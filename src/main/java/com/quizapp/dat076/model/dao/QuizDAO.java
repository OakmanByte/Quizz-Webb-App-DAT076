/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;


import com.mysema.query.jpa.impl.JPAQuery;
import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.QQuiz;
import com.quizapp.dat076.model.entity.Quiz;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/**
 *
 * @author Albin, Anton
 */
@Stateless
public class QuizDAO extends AbstractDAO<Integer,Quiz> {
    
    
    @Getter @PersistenceContext(unitName = "QuizApp")
    private EntityManager entityManager;
    private QQuiz quiz = QQuiz.quiz;
    private JPAQuery query;
    
    
    public QuizDAO(){
        super(Quiz.class);
    }
    
    
    public List<Quiz>findQuizzesByTitle(String title) {
        
        query = new JPAQuery(entityManager);    
        
        return query.from(quiz).where(quiz.title.eq(title)).list(quiz);
        
    }
    
    /*public List<Quiz> findQuizzesByCreator(Account creator){
        
        JPAQuery query = new JPAQuery(entityManager);  
        
        List<Quiz> quizzes = query.from(quiz).where(quiz.creator.eq(creator)).fetch();
        return quizzes;
        
    }*/
    
    /*public void removeQuizById(int id){
        
       // queryFactory.delete(quiz).where(quiz.id.eq(id)).execute();
        
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
        
    //}
    
    /*public void removeAllQuizzesByCreator(Account creator){
        
        queryFactory.delete(quiz).where(quiz.creator.eq(creator)).execute();
        
    }*/
    
    
}
