
import com.quizapp.dat076.model.dao.AccountDAO;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;
import javax.faces.validator.Validator;
import javax.faces.application.FacesMessage;
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
@FacesValidator("emailValidator")
@Named
public class EmailValidator implements Validator {

    private static final Pattern EMAIL_PATTERN
            = Pattern.compile("^(.+)@(.+)$");

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

        String email = (String) o;
        boolean matches = EMAIL_PATTERN.matcher(email)
                .matches();
        
        if (!matches) {
            FacesMessage msg = new FacesMessage(
                    FacesMessage.SEVERITY_FATAL,
                    "Email is invalid",
                    null);
            throw new ValidatorException(msg);
        }

        if (accountDAO.findAccountByEmail(email) != null) {
            FacesMessage msg = new FacesMessage(
                    FacesMessage.SEVERITY_FATAL,
                    "Email already exists!",
                    null);
            throw new ValidatorException(msg);
        }

    }
}
