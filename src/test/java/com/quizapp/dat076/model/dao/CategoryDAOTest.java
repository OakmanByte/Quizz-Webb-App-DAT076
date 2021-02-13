/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.quizapp.dat076.model.entity.Account;
import com.quizapp.dat076.model.entity.Category;
import com.quizapp.dat076.model.entity.Quiz;
import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Rebecka Axelborn
 */

@RunWith(Arquillian.class)
public class CategoryDAOTest {
    Category test1 = new Category("Geography");
    Category test2 = new Category("Math");
    Category test3 = new Category("Music");
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(CategoryDAO.class, Category.class, Quiz.class, Account.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    @EJB
    private CategoryDAO categoryDAO;

    @Before
    //TODO
    public void setUp() {
        categoryDAO.create(test1);
        categoryDAO.create(test2);
        categoryDAO.create(test3);
    }
    
    @After
    public void tearDown(){
        categoryDAO.remove(test1);
        categoryDAO.remove(test2);
        categoryDAO.remove(test3);
    }

    @Test
    //TODO
    public void checkThatFindCategoryCorrectly() {
        Assert.assertTrue(categoryDAO.findCategory("Geography") != null);
        Assert.assertTrue(categoryDAO.findCategory("Math") != null);
        Assert.assertTrue(categoryDAO.findCategory("Music") != null);
    }
    
}
