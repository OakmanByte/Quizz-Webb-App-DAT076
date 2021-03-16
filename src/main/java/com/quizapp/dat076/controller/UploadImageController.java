/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizapp.dat076.controller;

import com.quizapp.dat076.view.RegisterBackingBean;
import com.quizapp.dat076.model.UserBean;
import com.quizapp.dat076.model.dao.AccountDAO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import lombok.Data;
import org.omnifaces.util.Utils;

/**
 * Backing bean for handling uploading of profile pictures in accountpage.xhtml. Utilizes omnifaces inputFile component. 
 * @author Anton Ekman
 * @author Omnifaces unknown contributor
 */
@Named
@RequestScoped
@Data
public class UploadImageController {

    private Part file = null;
    private byte[] content;
    File img = null;
    @Inject
    private UserBean userBean;

    @EJB
    private AccountDAO accountDAO;

    public void read() throws IOException {
        /*
        if(file == null){
            img = new File("ProfilePicturePlaceholder.jpg");
            file = img;
        }*/
           try {                  
            content = Utils.toByteArray(file.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(RegisterBackingBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        userBean.getAccount().setProfilePicture(content);
        accountDAO.update(userBean.getAccount());

    }
}
