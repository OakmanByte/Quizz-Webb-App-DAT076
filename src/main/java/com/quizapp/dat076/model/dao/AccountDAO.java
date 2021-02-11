/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.impl.JPAUpdateClause;
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
public class AccountDAO extends AbstractDAO<String, Account> {

    @Getter
    @PersistenceContext(unitName = "QuizApp")
    private EntityManager entityManager;
    private QAccount account = QAccount.account;

    public AccountDAO() {
        super(Account.class);
        //query = new JPAQuery(entityManager);
    }

    public Account findByEmail(String email) {
        JPAQuery query = new JPAQuery(entityManager);
        return query.from(QAccount.account)
                .where(QAccount.account.email.eq(email))
                .singleResult(account);
    }

    public Account findByUsername(String username) {
        JPAQuery query = new JPAQuery(entityManager);
        return query.from(QAccount.account)
                .where(QAccount.account.username.eq(username))
                .singleResult(account);
    }
}
