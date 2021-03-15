/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.dao.AccountDAO;
import com.quizapp.dat076.model.dao.CategoryDAO;
import com.quizapp.dat076.model.entity.Category;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;

/**
 * Backing Bean for accountsettings.xhtml
 * @author Anton Ekman
 * 
 *
 */
@Data
@Named
@ViewScoped
public class AccountSettingsBackingBean implements Serializable {

    @EJB
    private CategoryDAO categoryDAO;

    @EJB
    private AccountDAO accountDAO;

    @Inject
    private UserBean userBean;

    public List<Category> getCategories() {

        return categoryDAO.findAll();

    }

    public String updateAgeandFavoriteQuizz() {

        accountDAO.update(userBean.getAccount());

        return "account.xhtml" + "?faces-redirect=true";

    }

}
