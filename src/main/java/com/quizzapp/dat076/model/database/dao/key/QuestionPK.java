/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizzapp.dat076.model.database.dao.key;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author anton
 * Composite key for Question since it needs the quiz id aswell
 */
@Data
public class QuestionPK implements Serializable {
    
    private String question;
    private int id;
   
}