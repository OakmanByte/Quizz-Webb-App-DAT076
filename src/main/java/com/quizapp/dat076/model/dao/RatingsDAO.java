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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaQuery;
import lombok.Getter;

/**
 *
 * @author anton
 */
@Stateless
public class RatingsDAO extends AbstractDAO<String, Ratings> {

    @Getter
    @PersistenceContext(unitName = "QuizApp")
    private EntityManager entityManager;
    private JPAQuery query;
    private QRatings rating = QRatings.ratings;
      List<Ratings> ratings;

 public List<Ratings> getRatigns() {
        return new ArrayList<>(ratings);
    }

  
    public RatingsDAO() {
        super(Ratings.class);
        query = new JPAQuery(entityManager);
    }

    
    public List<Ratings> getRatings(int size) {

        if (size > ratings.size()) {
            Random rand = new Random();

            List<Ratings> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(ratings.size());
                randomList.add(ratings.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(ratings.subList(0, size));
        }
    }

    
    public void addRating(Ratings rating){
        entityManager.persist(rating);
    }
    
    public List<Ratings> findAllRatings(){
        CriteriaQuery<Ratings> cq = entityManager.getCriteriaBuilder().createQuery(Ratings.class);
        cq.select(cq.from(Ratings.class));
        return entityManager.createQuery(cq).getResultList();
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
