/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.repository;

import com.vhd.pojo.Accounts;
import java.util.List;

/**
 *
 * @author PC
 */
public interface AccountRepository {
    List<Accounts> getAccounts();
    List<Accounts> getAccounts(String username);
    boolean addOrUpdateAccount(Accounts a);
    Accounts getAccountByUsername(String username);
    Accounts getAccountById(int id);
    Accounts getAccountByname(String username);
    boolean authUser(String username, String password);
    Accounts addAccount(Accounts account);
}
