/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.controller;


import com.quizapp.dat076.model.entity.Ratings;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Antpack
 */
@Named
@ApplicationScoped
public class RatingsController {
    
         List<Ratings> ratings;

        public List<Ratings> getRatings() {
        return new ArrayList<>(ratings);
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

  
    
}
