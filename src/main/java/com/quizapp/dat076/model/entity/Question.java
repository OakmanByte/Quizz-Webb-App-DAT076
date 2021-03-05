/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.entity;

import com.quizzapp.dat076.model.database.dao.key.QuestionPK;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity Class for a question and it's alternativs. 
 * @author Albin
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(QuestionPK.class)
public class Question implements Serializable {

    //@id private int id;
    @Id
    private String question;
    @Id
    private int id;
    //Attributes
    @NotNull
    private String alt1;
    @NotNull
    private String alt2;
    @NotNull
    private String alt3;
    @NotNull
    private String alt4;
    @NotNull
    private int answer;
    //Relations
    @ManyToOne
    private Quiz quiz;

}
