/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.entity;

import com.quizzapp.dat076.model.database.dao.key.LeaderboardPK;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class for a leaderboard that can be used for each unique quizz.
 * @author Rebec
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Leaderboard implements Serializable {

    @EmbeddedId
    LeaderboardPK leaderID;

    @ManyToOne
    @MapsId("username")
    @JoinColumn(name = "user_name")
    Account account;

    @ManyToOne
    @MapsId("quizID")
    @JoinColumn(name = "quiz_id")
    Quiz quiz;

    Integer score;

}
