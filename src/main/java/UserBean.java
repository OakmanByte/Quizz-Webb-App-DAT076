
import com.quizapp.dat076.model.dao.AccountDAO;
import com.quizapp.dat076.model.entity.Account;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.Setter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emma Dirnberger
 */
@RequestScoped
//@Named("user")
@Setter
@Getter
public class UserBean {
    
    private String username;
    private String email;
    private String password;

    @EJB
    private AccountDAO accountDAO;
    
    @PostConstruct
    public void init() {
        username = "";
        email = "";
        password = "";
    }
    
    public void add() {
       Account accountToCreate = new Account(username, email, password, null);
       //System.out.println("***** " + username);
       
       if(!userExists()) {
          accountDAO.create(accountToCreate); 
       }
       
      // System.out.println(accountDAO.findAccountByUsername(accountToCreate.getUsername()));
       username = "";
       email = "";
       password = "";
    }
    
    public boolean userExists(){
        
        return accountDAO.findAccountByEmail(email) != null ||
                accountDAO.findAccountByUsername(username) != null;
    }
}
