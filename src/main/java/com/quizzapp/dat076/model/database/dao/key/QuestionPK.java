/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizzapp.dat076.model.database.dao.key;

import java.io.Serializable;

/**
 *
 * @author anton
 */
public class QuestionPK  {
    
    private String question;
    private int id;
    
// Question is a waek entitety , uniquliy identifeied by its primary key and quizz id 

@Override
public int hashCode() {
    return id * 12345;
}

@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof QuestionPK) {
            
        }

        return false;
    }


}




