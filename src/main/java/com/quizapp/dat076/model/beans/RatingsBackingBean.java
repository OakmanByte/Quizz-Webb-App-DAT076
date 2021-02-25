/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.dao.AccountDAO;
import homepageBeans.LoginViewBean;
import com.quizapp.dat076.model.entity.Ratings;
import com.quizapp.dat076.model.dao.RatingsDAO;
import com.quizapp.dat076.model.entity.Account;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
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
    @EJB
    private AccountDAO accountDAO;
    @Inject
    private LoginViewBean loginviewbean;
    private int ratingsScore;

    private int ratingsId;
    private String ratingsReview;
    private Account ratingscreator;
    private int ratingscategory;
    
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
     
       rating.setScore(ratingsScore);
       rating.SetReview(ratingsReview);
       rating.setCategory(ratingscategory);
       rating.setCreator(accountDAO.findAccountByUsername(loginviewbean.getUsername()));
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
