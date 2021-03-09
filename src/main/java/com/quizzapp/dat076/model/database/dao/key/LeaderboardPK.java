/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizzapp.dat076.model.database.dao.key;

import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.Quiz;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A class for handling composite keys for the leaderboard "entity".
 * @author Rebecka
 */
@Data
public class LeaderboardPK implements Serializable {

   
    private Account account;
    private Quiz quiz;

}
