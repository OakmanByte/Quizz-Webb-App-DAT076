/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.mysema.query.jpa.impl.JPAQuery;
import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.Category;
import com.quizapp.dat076.model.entity.QAccount;
import com.quizapp.dat076.model.entity.QCategory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/**
 *
 * @author anton
 */
//Make sure correct Datatype in <>
@Stateless
public class CategoryDAO extends AbstractDAO<String,Category> {
    

    @Getter
    @PersistenceContext(unitName = "QuizApp")
    private EntityManager entityManager;
    private JPAQuery query;
    private QCategory category = QCategory.category1;

    public CategoryDAO() {
        super(Category.class);
        query = new JPAQuery(entityManager);
    }
    public int test(){
    
    return 0;
    }
}
