/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.mysema.query.jpa.impl.JPAQuery;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.quizapp.dat076.model.entity.QRatings;
import com.quizapp.dat076.model.entity.Ratings;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import lombok.Getter;

/**
 * A DAO for the entity ratings. Has methods for retrivng all ratings, finding highest score with or without a specifc score argument. 
 * @author Unknown
 */
@Stateless
public class RatingsDAO extends AbstractDAO<String, Ratings> {

    @Getter
    @PersistenceContext(unitName = "QuizApp")
    private EntityManager entityManager;
    private JPAQuery query;
    private QRatings rating = QRatings.ratings;

    public RatingsDAO() {
        super(Ratings.class);
        query = new JPAQuery(entityManager);
    }

      public List<Ratings> findratingsByQuizID(int id) {

        query = new JPAQuery(entityManager);

        return query.from(rating).where(rating.quiz.id.eq(id)).list(rating);

    }
      
    public List<Ratings> findratingsByUsername(String username){
    
         query = new JPAQuery(entityManager);
         return query.from(rating).where(rating.creator.username.eq(username)).list(rating);
    }
    


    //TODO shouldn't it be highest score for a quiz?
    public int FindHighestRatingScore(int id) {
        JPAQuery query = new JPAQuery(entityManager);
        List<Ratings> scores;
         scores = query.from(rating).where(rating.quiz.id.eq(id)).list(rating);
         int maxScore = 0;
         for(int i = 0 ; i< scores.size(); i++){
             
             if(scores.get(i).getScore() > maxScore){
                maxScore = scores.get(i).getScore(); 
             }
         }
         return maxScore;
    }

}
