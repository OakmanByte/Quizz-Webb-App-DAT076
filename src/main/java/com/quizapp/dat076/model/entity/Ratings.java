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
     
    
}
