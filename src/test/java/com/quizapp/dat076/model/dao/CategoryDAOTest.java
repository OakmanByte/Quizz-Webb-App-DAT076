/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.dao;

import com.quizapp.dat076.model.entity.Category;
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
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(CategoryDAO.class, Category.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    @EJB
    private CategoryDAO categoryDAO;

    @Before
    //TODO
    public void init() {
        categoryDAO.create(new Category("Geography"));
    }

    @Test
    //TODO
    public void checkThatFindCategoryCorrectly() {
        Assert.assertTrue(true);
        /* Some better condition */
    }
    
}
