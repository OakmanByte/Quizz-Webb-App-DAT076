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
 * A DAO for the account entity. Has methods for retriving accounts with an email and/or username. 
 * @author Emma Dirnberger
 * @author Anton Blomdell
 */
@Stateless
public class AccountDAO extends AbstractDAO<String, Account> {

    @Getter
    @PersistenceContext(unitName = "QuizApp")
    private EntityManager entityManager;
    private final QAccount account = QAccount.account;

    public AccountDAO() {
        super(Account.class);
    }

    public Account findAccountByEmail(String email) {
        JPAQuery query = new JPAQuery(entityManager);
        return query.from(QAccount.account)
                .where(QAccount.account.email.eq(email))
                .singleResult(account);
    }

    public Account findAccountByUsername(String username) {
        JPAQuery query = new JPAQuery(entityManager);
        return query.from(QAccount.account)
                .where(QAccount.account.username.eq(username))
                .singleResult(account);
    }
}
