/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homepageBeans;

import com.quizapp.dat076.model.dao.CategoryDAO;
import com.quizapp.dat076.model.entity.Category;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author anton
 */
@Named
@RequestScoped
public class AccountSettingsBean implements Serializable{
    
    private String category;
    
    @EJB
    private CategoryDAO categoryDAO;
    
     public boolean validateCategory() {

        Category C = categoryDAO.findCategory(category);

        return C != null;
    }
    
}
