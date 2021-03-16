/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.view;

import com.quizapp.dat076.model.UserBean;
import com.quizapp.dat076.model.dao.QuizDAO;
import com.quizapp.dat076.model.dao.RatingsDAO;
import com.quizapp.dat076.model.entity.Quiz;
import com.quizapp.dat076.model.entity.Ratings;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import lombok.Data;
import org.omnifaces.cdi.Param;
import org.primefaces.PrimeFaces;

/**
 * Backing Bean for ratingsresults.xhtml
 * @author Anton Blomdell
 */
@Data
@Named
@ViewScoped
public class RatingsListBackingBean implements Serializable {

    private List<Ratings> allRatings;
    
    private List<Quiz> ratingsquiz;
  //  private List<Ratings> averageRating;
    private List<Integer> averagescores;
    

     
    private int quizId;
     
    @EJB
    private RatingsDAO ratingsDAO;
    @EJB
    private QuizDAO quizDAO;
     @Inject
    private UserBean userBean;
    //  private RatingsController ratingsController;
    @PostConstruct
    public void postConstruct() {
        allRatings = ratingsDAO.findAll();
       
    }
   
    public List<Ratings> allratingsByName(){
    List<Ratings> myratings;
    myratings = ratingsDAO.findratingsByUsername(userBean.getAccount().getUsername());
    return myratings;
    }   
}