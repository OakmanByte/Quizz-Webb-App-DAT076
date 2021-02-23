
import com.quizapp.dat076.model.dao.AccountDAO;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Emma Dirnberger
 */
@FacesValidator("usernameValidator")
@Named
public class UsernameValidator implements Validator {

    //TODO - pattern making sure username has a certain min/max length
    @EJB
    private AccountDAO accountDAO;

    @Override
    public void validate(FacesContext facesContext,
            UIComponent uiComponent,
            Object o)
            throws ValidatorException {
        
        if (o == null) {
            return;
        }

        String username = (String) o;

        if (accountDAO.findAccountByUsername(username) != null) {
            FacesMessage msg = new FacesMessage(
                    FacesMessage.SEVERITY_FATAL,
                    "Username already exists!",
                    null);
            throw new ValidatorException(msg);
        }
    }

}
