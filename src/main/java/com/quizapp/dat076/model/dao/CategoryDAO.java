/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.mysema.query.jpa.impl.JPAQuery;
import com.quizapp.dat076.model.entity.Category;
import com.quizapp.dat076.model.entity.QCategory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/*
 * @author Rebecka Axelborn
 */
@Stateless
public class CategoryDAO extends AbstractDAO<String,Category>{

    @Getter @PersistenceContext(unitName = "QuizApp")
    private EntityManager entityManager;
    private JPAQuery query;
    private QCategory cat = QCategory.category1;
    
    public CategoryDAO(){
        super(Category.class);
        query=new JPAQuery(entityManager);
    }
    
//TODO
    public Category findCategory(String catInput) {

        if(query==null){
            query= new JPAQuery(entityManager);
        }
        QCategory cat= QCategory.category1;
        
        query = new JPAQuery(entityManager);
        Category c =query.from(cat)
                .where(cat.category.eq(catInput))
                .singleResult(cat);
        
       /* query = new JPAQuery(entityManager);
        
        return query.from(QCategory.category1)
                .where(QCategory.category1.category.eq(catInput))
                .singleResult(cat);*/

       System.out.println(c.toString());
        return c;
        
    }
}
