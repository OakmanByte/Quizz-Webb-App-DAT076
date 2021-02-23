/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.mysema.query.jpa.impl.JPAQuery;
import com.quizapp.dat076.model.entity.Leaderboard;
import com.quizapp.dat076.model.entity.QLeaderboard;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/*
 * @author Rebecka Axelborn
 */
@Stateless
public class LeaderboardDAO extends AbstractDAO<String,Leaderboard>{

    @Getter @PersistenceContext(unitName = "QuizApp")
    private EntityManager entityManager;
    private JPAQuery query;
    private QLeaderboard qLeaderboard = QLeaderboard.leaderboard;
    
    public LeaderboardDAO(){
        super(Leaderboard.class);
        query=new JPAQuery(entityManager);
    }
    

    public List<Leaderboard> findScoresByQuizID(int quizID) {
        
        query = new JPAQuery(entityManager);
        
        return query.from(qLeaderboard).where(qLeaderboard.quiz.id.eq(quizID)).list(qLeaderboard);
        
    }
}