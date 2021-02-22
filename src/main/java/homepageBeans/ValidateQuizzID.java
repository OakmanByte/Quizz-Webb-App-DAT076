/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homepageBeans;

import com.quizapp.dat076.model.dao.QuizDAO;
import com.quizapp.dat076.model.entity.Quiz;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import lombok.Data;

/**
 *
 * @author anton
 */
@Data
public class ValidateQuizzID {

    private int id;
    @EJB
    private QuizDAO quizDAO;
    @Inject
    LoginViewBean loginViewBean;
    @Inject
    private SecurityContext securityContext;
    
	public Boolean validateQuizzId() {
            
                    
    loginViewBean.getUsername();
        
    securityContext.isCallerInRole("admin");
    
            Quiz Q = quizDAO.findQuizByID(id);
            
            return Q!= null;
}
        
}
