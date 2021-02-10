/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.mysema.query.jpa.impl.JPAQuery;
import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.QAccount;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/**
 *
 * @author Emma Dirnberger, Anton
 */
@Stateless
public class AccountDAO extends AbstractDAO<String,Account> {

    @Getter
    @PersistenceContext(unitName = "QuizApp")
    private EntityManager entityManager;
    private JPAQuery query;
    private QAccount account = QAccount.account;

    public AccountDAO() {
        super(Account.class);
        query = new JPAQuery(entityManager);
    }

    public JPAQuery findByEmail(String email) {
        if (null == query) {
            query = new JPAQuery(entityManager);
        }
        
        QAccount ac = QAccount.account;

        JPAQuery c = query.from(ac)
                .where(ac.email.eq(email))
                .fetch();

        return c;
    }

    public void findByUsername(String username) {
        //TODO
    }

    public void updateEmail(String email) {
        //TODO
    }

}
