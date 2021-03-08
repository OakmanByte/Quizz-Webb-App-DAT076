package com.quizapp.dat076.model;

import com.quizapp.dat076.model.dao.AccountDAO;
import com.quizapp.dat076.model.entity.Account;
import static java.util.Arrays.asList;
import java.util.HashSet;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import javax.security.enterprise.identitystore.IdentityStore;

/**
 * This class is an identitystore that handles the validation of a caller's credentialss. In this case it's managing the login functionallity of the website.
 * @author Anton Ekman 
 * 
 */
@ApplicationScoped
public class DatabaseIdentityStore implements IdentityStore {

    @EJB
    private AccountDAO accountDAO;

    public CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {

        Account account = accountDAO.findAccountByUsername(usernamePasswordCredential.getCaller());
        
        Argon2PasswordHashing argon = new Argon2PasswordHashing();
        
        //if (account != null && account.getPassword().equals(usernamePasswordCredential.getPasswordAsString())) {
       
        if (account != null && argon.verifyPassword(account.getPassword(), usernamePasswordCredential.getPasswordAsString().toCharArray())) {
            //fill in list with roles that exist get roll from databse and store in list 
            return new CredentialValidationResult(account.getUsername(), new HashSet<>(asList(account.getUserrole())));
        }
        System.out.println("THIS IS WHERE THE PROBELM IS");
        return INVALID_RESULT;
    }
}
