/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.quizapp.dat076.model.entity.Account;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import lombok.Getter;

/**
 *
 * @author Emma Dirnberger
 */
@Stateless
public class AccountDAO extends AbstractDAO<Account>{

    @Getter @PersistenceContext(unitName = "QuizApp")
    private EntityManager entityManager;
    
    public AccountDAO(){
        super(Account.class);
    }
    
    public List<Account>findAccountsMatchingName() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public void findByEmail(String email) {
        //TODO
    }
    
    public void findUser(String username) {
        //TODO
    }
    
}
