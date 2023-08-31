/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.service;

import com.vhd.pojo.Accounts;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author PC
 */
public interface AccountService extends UserDetailsService{
    List<Accounts> getAccounts();
    List<Accounts> getAccounts(String username);
    boolean addOrUpdateAccount(Accounts a);
    Accounts getAccountById(int id);
    Accounts getAccountByname(String username);
    boolean authUser(String username, String password);
}
