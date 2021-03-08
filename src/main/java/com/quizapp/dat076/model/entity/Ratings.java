/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.entity;

import com.quizzapp.dat076.model.database.dao.key.RatingsPK;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class for the ratings entity. 
 * @author Anton Ekman
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(RatingsPK.class)
public class Ratings implements Serializable {

    
    //YOU CAN NOT HAVE Generatedvalues for a composite key like this, i think? //Anton
    @Id
    @GeneratedValue
    private int id;
    @Id
    private int category;
    private int score;
    private String review;
    @ManyToOne
    private Account creator;
    @OneToOne
    private Quiz quiz;

    public Ratings(int category, int score, String review, Account creator, Quiz quiz) {
        super();
        this.score = score;
        this.review = review;
        this.creator = creator;
        this.quiz = quiz;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getReview() {
        return review;
    }

    public void SetReview(String review) {
        this.review = review;
    }

    public void setUsername(String username) {
        this.creator.setUsername(username);
    }

}
