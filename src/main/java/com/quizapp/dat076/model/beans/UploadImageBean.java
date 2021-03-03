/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.model.beans;

import com.quizapp.dat076.model.dao.AccountDAO;
import java.io.IOException;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import lombok.Data;
import org.omnifaces.util.Utils;

/**
 *
 * @author anton
 */
@Named
@RequestScoped
@Data
public class UploadImageBean {

    private Part file;
    private byte[] content;

    @Inject
    private UserBean userBean;

    @EJB
    private AccountDAO accountDAO;

    public void read() throws IOException {
        content = Utils.toByteArray(file.getInputStream());

        userBean.getAccount().setProfilePicture(content);
        accountDAO.update(userBean.getAccount());
    }
}
