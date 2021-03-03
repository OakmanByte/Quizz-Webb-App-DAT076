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
 *
 * @author anton
 * @RolesAllowed == tillåt metoder från viss roll (allowed roles atr) implemnt
 * roles in database
 */
@ApplicationScoped
public class DatabaseIdentityStore implements IdentityStore {

    @EJB
    private AccountDAO accountDAO;

    public CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {

        Account account = accountDAO.findAccountByUsername(usernamePasswordCredential.getCaller());

        if (account != null && account.getPassword().equals(usernamePasswordCredential.getPasswordAsString())) {
            //fill in list with roles that exist get roll from databse and store in list 
            return new CredentialValidationResult(account.getUsername(), new HashSet<>(asList(account.getUserrole())));
        }
        return INVALID_RESULT;
    }
}
