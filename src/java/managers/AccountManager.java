/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import daos.AccountDAO;
import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import models.Account;

/**
 *
 * @author Shawn
 */
@WebListener
public class AccountManager implements ServletContextListener{
    
    @EJB
    private AccountDAO accs;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("accountManager", this);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
    public boolean accountExists(String username) {
        return accs.accountExists(username);
    }

    public boolean createNewAccount(String username, String firstName, String lastName, String email, String password) {
        boolean exists = accountExists(username);
        if(exists) {
            return exists; 
        }
        else {
            short notLoggedIn = (short) 0;
            Account newAccount = new Account(username, firstName, lastName, email, password, notLoggedIn);
            accs.create(newAccount);
            return exists;
        }
    }   
    
    public Account find(int id) {
        return accs.find(id);
    }
    
    public void update(Account user) {
        accs.edit(user);
    }

    public boolean validateAccountInformation(String username, String password) {
        return accs.validateAccountInformation(username, password);
    }
    
    public Account getUser(String username) {
        Account user = accs.getUser(username);
        return user;
    }
    
    /*
    private String hashPassword(String password) {
        
    }
    
    private String decodePassword(String password) {
        
    }
    */
}
