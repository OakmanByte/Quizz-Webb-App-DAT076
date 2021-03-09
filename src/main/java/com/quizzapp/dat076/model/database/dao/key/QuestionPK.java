/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizzapp.dat076.model.database.dao.key;

import com.quizapp.dat076.model.entity.Quiz;
import java.io.Serializable;
import lombok.Data;

/**
 * A class for handling composite keys for the question entity.
 * @author Anton Ekman 
 */
@Data
public class QuestionPK implements Serializable {

    private String questionID;
    private int quiz; 

}
