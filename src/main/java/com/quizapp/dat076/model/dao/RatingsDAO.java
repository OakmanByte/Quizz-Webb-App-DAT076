/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.mysema.query.jpa.impl.JPAQuery;
import com.quizapp.dat076.model.entity.Category;
import com.quizapp.dat076.model.entity.QCategory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.quizapp.dat076.model.entity.QRatings;
import com.quizapp.dat076.model.entity.Ratings;
import java.util.List;
import lombok.Getter;

/**
 *
 * @author anton
 */
@Stateless
public class RatingsDAO extends AbstractDAO<String,Ratings> {
    

    @Getter
    @PersistenceContext(unitName = "QuizApp")
    private EntityManager entityManager;
    private JPAQuery query;
    private QRatings rating = QRatings.ratings;

    public RatingsDAO() {
           super(Ratings.class);
            query = new JPAQuery(entityManager);
    }
    
  public Ratings FindHighRated(int score)
   {
       JPAQuery query = new JPAQuery(entityManager);
       
       return query.from(rating).where(rating.score.loe(score)).singleResult(rating);
      
      
   }
public int FindHighestRated(){
      JPAQuery query = new JPAQuery(entityManager);
      int maxRating = query.from(rating).list(rating.score.max()).get(0);
      return maxRating;
}
}
