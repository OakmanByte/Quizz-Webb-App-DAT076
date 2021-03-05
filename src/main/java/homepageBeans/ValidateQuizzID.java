/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homepageBeans;

import com.quizapp.dat076.model.dao.QuizDAO;
import com.quizapp.dat076.model.entity.Quiz;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;

import lombok.Data;

/**
 * Not used atm, for homepage if you wanna enter quizz id and go to quizz id instead of what we do now.
 * @author anton
 */

/*
@Named
@Data
public class ValidateQuizzID implements Serializable {

    private int id;
    @EJB
    private QuizDAO quizDAO;

    public String quizExists() {

        Quiz Q = quizDAO.findQuizByID(id);

        if ( Q != null ) {
        
        return "quizpage";
        }
        else
            return "";
    }

}
*/
