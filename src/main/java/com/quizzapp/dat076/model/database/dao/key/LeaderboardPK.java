/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizzapp.dat076.model.database.dao.key;

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
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class LeaderboardPK implements Serializable {

    @Column(name = "user_name")
    String username;

    @Column(name = "quiz_id")
    int quizID;

}
