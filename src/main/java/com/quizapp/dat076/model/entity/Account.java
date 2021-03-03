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
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String userrole;
   //Aknowlefge indte snyggt
    private String favoritecategory; 
    @Min(0)
    @Max(110)
    private int age;
    
    //Check out LOB annotation, saving bytestream for user profile picture
    //private byte[] profilePicture;
    //and merge after setter 

   
    @OneToMany(mappedBy = "creator")
    private List<Quiz> createdQuizzes;

}
