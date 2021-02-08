/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.quizapp.dat076.model.entity.Category;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/**
 *
 * @author Rebecka Axelborn
 */
@Stateless
public class CategoryDAO extends AbstractDAO<Category>{

    @Getter @PersistenceContext(unitName = "QuizApp")
    private EntityManager entityManager;
    
    public CategoryDAO(){
        super(Category.class);
    }
    
//TODO
    public Category findCategory(String username) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
