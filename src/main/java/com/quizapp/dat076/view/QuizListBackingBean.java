/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.view;

import com.quizapp.dat076.model.dao.CategoryDAO;
import com.quizapp.dat076.model.dao.QuizDAO;
import com.quizapp.dat076.model.dao.RatingsDAO;
import com.quizapp.dat076.model.entity.Category;
import com.quizapp.dat076.model.entity.Quiz;
import com.quizapp.dat076.model.entity.Ratings;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;

/**
 * Backing Bean for available_quizzes.xhtml
 * @author Albin
 */
@Data
@Named
@ViewScoped
public class QuizListBackingBean implements Serializable {
    
    //Retrieve the beans for the needed DAO:s
    @EJB
    private QuizDAO quizDAO;
    
    @EJB
    private CategoryDAO catDAO;
    
    @EJB
    private RatingsDAO ratingsDAO;
    
    //The list of all quizzes
    private List<Quiz> quizzes;
    
    //The list of quizzes with filters applied
    private List<Quiz> filteredQuizzes;
    
    /**
     * Initialize the bean by retrieving the list of all quizzes
     **/
    @PostConstruct
    private void init() {
        
        quizzes = quizDAO.findAll();
        
    }
    
    public List<Category> getAllCategories(){
        return catDAO.findAll();
    }
  
   public int getAverageScore(int id){
      
   List<Ratings> ratingslst;
   int temp = 0 ;
 
        
            ratingslst = ratingsDAO.findratingsByQuizID(id);
                for(int y = 0; y<ratingslst.size(); y++){
                    temp = temp + ratingslst.get(y).getScore();
                }
                if(ratingslst.isEmpty()){
                
                }
                else{
                    temp = temp / ratingslst.size();
                }
               
   
   return temp;
   
   }
}