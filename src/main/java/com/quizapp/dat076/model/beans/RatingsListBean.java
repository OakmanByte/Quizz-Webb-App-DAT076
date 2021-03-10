/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

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
public class RatingsListBean implements Serializable {

    private List<Ratings> allRatings;
    private Ratings selectedRating;
    private List<Ratings> selectedRatings;
    private List<Ratings> averageRatingscore;
    
    private List<Quiz> averageQuizes;
    
    private List<Integer> averageScores;
     @Inject
    @Param(name = "quizId")
    private int quizId;
     
    @EJB
    private RatingsDAO ratingsDAO;
    @EJB
    private QuizDAO quizDAO;

    //  private RatingsController ratingsController;
    @PostConstruct
    public void postConstruct() {
        allRatings = ratingsDAO.findAll();
       
    }
    
    public int AverageScore(){
        int temp1= 0;
        
        averageRatingscore = ratingsDAO.findratingsByQuizID(quizId);
        for(int i = 0; i< averageRatingscore.size(); i++){
            temp1 = temp1 + averageRatingscore.get(i).getScore();
        }
        temp1 = temp1 / averageRatingscore.size();
    
        return temp1;
    }

}
