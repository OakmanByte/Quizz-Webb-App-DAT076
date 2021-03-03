/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homepageBeans;

import com.quizapp.dat076.model.beans.UserBean;
import com.quizapp.dat076.model.dao.AccountDAO;
import java.io.Serializable;
import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import lombok.Data;
import org.omnifaces.util.Faces;

@DeclareRoles({"admin", "user"})
@CustomFormAuthenticationMechanismDefinition(loginToContinue = @LoginToContinue(useForwardToLogin = false))
@RequestScoped
@Named
@Data
public class LoginController implements Serializable {

    @Inject
    private SecurityContext securityContext;
    @Inject
    private UserBean userBean;
    @Inject 
    private AccountDAO accountDAO;

    public String login() {

        final Credential credential = new UsernamePasswordCredential(userBean.getAccount().getUsername(), userBean.getAccount().getPassword());

        final AuthenticationStatus status = securityContext.authenticate(Faces.getRequest(), Faces.getResponse(), AuthenticationParameters.withParams().credential(credential));
        
        if(status == AuthenticationStatus.SUCCESS){
            
            userBean.setAccount(accountDAO.find(userBean.getAccount().getUsername())); 
            
            return "success";
        }
            
        return "";

    }

    public String logout() {
        Faces.invalidateSession();
        return "homepage.xhtml"+"?faces-redirect=true";
    }
}
