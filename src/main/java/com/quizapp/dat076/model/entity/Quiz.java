/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Quiz implements Serializable {
    
    @Id @GeneratedValue private int id;
    //Attributes
    @NotNull private String title;
    @ManyToOne private Account creator;
   // @ManyToOne private Category quizzCategory;
    
    //@OneToMany(mappedBy = "quiz") private List<Question> questions;
    
    
    /*public Quiz(String title, Account creator){
        this.title = title;
        this.creator = creator;
    }*/
   
    public Quiz(String title){
        this.title = title;
    }
}





