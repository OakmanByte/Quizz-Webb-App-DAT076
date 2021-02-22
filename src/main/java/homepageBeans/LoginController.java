/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homepageBeans;


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
    private LoginViewBean view;

    public String login() {

        final Credential credential = new UsernamePasswordCredential(view.getUsername(), view.getPassword());

        final AuthenticationStatus status = securityContext.authenticate(Faces.getRequest(), Faces.getResponse(), AuthenticationParameters.withParams().credential(credential));

        return status == AuthenticationStatus.SUCCESS ? "success" : "";
   
    }

    public String logout() {
        Faces.invalidateSession();
        return "";
    }
}
