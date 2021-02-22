/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizzapp.dat076.model.database.dao.key;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

/**
 *
 * @author Rebec
 */
@Data
@Embeddable
public class LeaderboardPK implements Serializable {
    @Column(name="user_name")
    String username;
    
    @Column(name="quiz_id")
    int quizID;
    
}
