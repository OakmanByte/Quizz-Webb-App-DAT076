/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
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
public class Account implements Serializable {

    @Id
    private String username;
    @Column(unique = true)
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String userrole;
   
    private String country; 
    private int age;
   
    @OneToMany(mappedBy = "creator")
    private List<Quiz> createdQuizzes;

}
