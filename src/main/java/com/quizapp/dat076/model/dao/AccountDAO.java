/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.QAccount;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/**
 *
 * @author Emma Dirnberger
 */
@Stateless
public class AccountDAO extends AbstractDAO<Account> {

    @Getter
    @PersistenceContext(unitName = "QuizApp")
    private EntityManager entityManager;
    private JPAQueryFactory queryFactory;
    private QAccount account = QAccount.account;

    public AccountDAO() {
        super(Account.class);
        queryFactory = new JPAQueryFactory(entityManager);
    }

    public Account findByEmail(String email) {
        if (null == queryFactory) {
            queryFactory = new JPAQueryFactory(entityManager);
        }
        
        QAccount ac = QAccount.account;

        Account c = queryFactory.selectFrom(ac)
                .where(ac.email.eq(email))
                .fetchOne();

        return c;
    }

    public void findByUsername(String username) {
        //TODO
    }

    public void updateEmail(String email) {
        //TODO
    }

}
