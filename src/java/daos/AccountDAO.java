/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IAccountDAO;
import models.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Reza
 */
public class AccountDAO implements IAccountDAO {
    
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    private Query query;

    public AccountDAO(SessionFactory factory) {
        this.factory = factory;
    }
    
    
}
