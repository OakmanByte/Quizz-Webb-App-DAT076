/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Albin
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
    @Id private String category;
    
    //Attributes
    @NotNull private int answer;
    //Relations
    //@ManyToOne private Quiz quiz;
    @OneToMany(mappedBy = "quizzCategory") private List<Quiz> categories;
    
    public Category (String category){
        this.category=category;
    }
}
