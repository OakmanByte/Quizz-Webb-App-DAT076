/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homepageBeans;
 
import com.quizapp.dat076.model.dao.AccountDAO;
import com.quizapp.dat076.model.entity.Account;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import homepageBeans.SessionUtils;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Data;

@Stateless
@Named
@Data
public class Login implements Serializable {
	
	private String password;
	private String msg;
	private String username;
        @EJB
        private AccountDAO accountDAO;


        
        
	//validate login
	public Boolean validateUsernamePassword() {
		
            Account A = accountDAO.findAccountByUsername(username);
               
                //if usename exist in database
                if (A!= null) {			
                    if(this.password.equals(A.getPassword())){
                        
                        return true;
                    }
                    else{
                        System.out.println("PASSWORD WAS INCORRECT");
                        return false;
                    }                                    
		} else {
		
                System.out.println("DIDNT WORK with validate");
                return false;
		}
	}
        
        public String login(){
            
            System.out.println("Result of validation:" + validateUsernamePassword() );
            
            //Starting connect
            if(validateUsernamePassword()){
            
                HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance( ).getExternalContext( ).getRequest( );        
                try {
                        request.login( username, password );
                        
                }
                catch ( ServletException e ) {
                    
                    FacesMessage facesMessage = new FacesMessage("This is a message");
                    FacesContext.getCurrentInstance().addMessage( "Unknown login", facesMessage);
                    return "failure";
                }       
                return "success";
            }
            return "failure";
       }


	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
}

