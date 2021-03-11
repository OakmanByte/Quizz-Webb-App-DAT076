/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model;

import java.time.Duration;
import java.time.Instant;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import javax.security.enterprise.credential.Password;

/**
 * Password hashing with Argon2. Method for hashing a password, and verifying a password with it's hash equivalent. 
 * @author Anton Ekman
 */
public class Argon2PasswordHashing {
    
    // Default argon2i, with params: salt 16 bytes, hash length 32 bytes.
    Argon2 argon2 = Argon2Factory.create();  
     
    public String hashPassword(String inputPassword) {  
        
    //Start timer
    Instant beginHash = Instant.now();
    
    //Testing password
    char[] password = inputPassword.toCharArray();
      
    //4 iterations, Memory = 65536k, 64M, Parallelism = 1, can be changed later
    String hash = argon2.hash(4, 65536, 1, password);
    System.out.println(String.format("Encoded hash is '%s'.", hash));
 
    //Stop timer
    Instant endHash = Instant.now();
    System.out.println(String.format("Process took %f s", Duration.between(beginHash, endHash).toMillis() / 1024.0));
   
    //Wipe confidential information
    argon2.wipeArray(password);
    
    return hash;
     }
    
public boolean verifyPassword(String hash, char[] password){
    
    // Default argon2i, with params: salt 16 bytes, hash length 32 bytes.
    
    boolean result = argon2.verify(hash, password);
            
    //Wipe confidential information
    argon2.wipeArray(password);
        
    return result;
    }
    
     
}
