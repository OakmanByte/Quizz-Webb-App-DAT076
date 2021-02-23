/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.dao.RatingsDAO;
import com.quizapp.dat076.model.entity.Ratings;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


/**
 *
 * @author Antpack
 */
@Named
public class RatingsListBean {
    
    @Inject
    private RatingsDAO ratingsDAO;
    private List<Ratings> allRatings;
    
    @PostConstruct
    public void postConstruct(){
        allRatings = ratingsDAO.findAllRatings();
    }
    
    public List<Ratings> getAllRatings(){
        return allRatings;
    }
    
}
