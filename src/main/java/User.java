
import com.quizapp.dat076.model.dao.AccountDAO;
import com.quizapp.dat076.model.entity.Account;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
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
@Named("user")
@Setter
@Getter
public class User {
    
    private String username;
    private String email;
    private String password;
    //TODO add account table stuff
    @EJB
    private AccountDAO accountDAO;
    
    public User() {
        username = "Test";
        email = "e@gmail.com";
        password = "pass";
    }
    
    public void add() {
        //TODO
        //Account accountToCreate = new Account(username, email, password, null);
       // accountDAO.create(accountToCreate);
    }
}
