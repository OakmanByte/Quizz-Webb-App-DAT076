/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.entity.Ratings;
import com.quizapp.dat076.model.dao.RatingsDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Data;

/**
 *
 * @author Antpack
 */

@Data
@Named
@ViewScoped
public class RatingsBackingBean implements Serializable 
{
    @EJB
    private RatingsDAO ratingsDAO;
    
    private int ratingsScore;
    private int ratingsCategory;
    private int ratingsId;
    private String ratingsReview;
    
    private Ratings rating;
    
   public int getScoreRating()
   {
       return ratingsScore;
   }
   public void setScoreRating(int ratingsScore)
   {
       this.ratingsScore=ratingsScore;
   }
   
   public String add(){
       Ratings rating = new Ratings();
       rating.setId(ratingsId);
       rating.setCategory(ratingsId);
       rating.setScore(ratingsScore);
       rating.SetReview(ratingsReview);
       ratingsDAO.addRating(rating);
       return "sucess";
   }
   public void update(){
     
       rating.SetReview(ratingsReview);
       rating.setScore(ratingsScore);
       ratingsDAO.update(rating);
   }
   
   public void delete(){
       ratingsDAO.remove(rating);
   
   }
}
