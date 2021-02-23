/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.entity;

import com.quizzapp.dat076.model.database.dao.key.RatingsPK;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author anton
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(RatingsPK.class)
public class Ratings implements Serializable {

   
     @Id private int category;
     @Id private int id;
     private int score;
     private String review;
     @ManyToOne private Account creator;
     @ManyToOne private Quiz quiz;
   

    public Ratings( int score, String review) {
        super();
        this.score = score;
        this.review = review;
    }
    
    
    public int getCategory()
    {
        return category;
    }
    
    public void setCategory(int category)
    {
        this.category = category;
    }
    
    public int getId()
    {
    return id;
    }
    
    public void setId(int id)
    {
    this.id = id;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void setScore(int score)
    {
        this.score = score;
    }
    public String getReview()
    {
       return review;
    }
    
    public void SetReview(String review)
    {
        this.review = review;
    }
     
}
