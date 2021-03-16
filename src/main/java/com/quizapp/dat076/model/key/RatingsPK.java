/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.key;

import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.Quiz;
import lombok.Data;

import java.io.Serializable;

/**
 * A class for handling composite keys for the ratings entity.
 * @author Anton Ekman
 */
@Data
public class RatingsPK implements Serializable {

   private String creator;
   private int quiz;

}
