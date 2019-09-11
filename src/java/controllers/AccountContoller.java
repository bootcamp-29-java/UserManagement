/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import idaos.IGeneralDAO;
import java.util.List;
import models.Account;
import org.hibernate.SessionFactory;

/**
 *
 * @author Reza
 */
public class AccountContoller {
    private SessionFactory factory;
    IGeneralDAO<Account> accdao;

    public AccountContoller(SessionFactory factory) {
        accdao = new GeneralDAO<>(factory,Account.class);
    }

    public List<Account> getAll(){
        return accdao.getAll();
    }
    
    public Account getById(String id){
        return accdao.getById(id);
    }
    
    

}