/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homepageBeans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;
import lombok.Data;

/**
 *
 * @author anton
 */
@Data
@Named
@SessionScoped
public class LoginViewBean implements Serializable {

    private String password;
    private String username;
    @Inject
    private SecurityContext securityContext;

    public boolean isAdmin() {

        return securityContext.isCallerInRole("admin");
    }

    public boolean isUser() {

        return username != null;
    }

}
