/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.Account;

/**
 *
 * @author Shawn
 */
@Stateless
public class AccountDAO extends AbstractDAO<Account> {

    @PersistenceContext(unitName = "InDangoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountDAO() {
        super(Account.class);
    }
    
    public List getAccountInfoListByUsername(String username) {
        List<Account> accounts;
        Query query = em.createNativeQuery("SELECT * FROM accounts WHERE username='" + username + "';", Account.class);
        accounts = (List<Account>)query.getResultList();
        return accounts;
    }
    
    public boolean accountExists(String username) {
        int minimumAccountListSize = 1;
        List accounts = getAccountInfoListByUsername(username);
        return accounts.size() >= minimumAccountListSize;
    }
    
    public boolean validateAccountInformation(String username, String password) {
        List<Account> accounts = getAccountInfoListByUsername(username);
        Account databaseAccountInfo = accounts.get(0);
        return databaseAccountInfo.getUsername().equalsIgnoreCase(username) && databaseAccountInfo.getPassword().equalsIgnoreCase(password);
    }
    
}
