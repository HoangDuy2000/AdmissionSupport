/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.service.Impl;

import com.cloudinary.utils.ObjectUtils;
import com.cloudinary.Cloudinary;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.vhd.pojo.Accounts;
import com.vhd.repository.AccountRepository;
import com.vhd.service.AccountService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service("userDetailService")
public class AccountServiceImpl implements AccountService{
    
    @Autowired
    private AccountRepository accountRepo;

    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Accounts u = this.accountRepo.getAccountByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("Invalid");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getRoles().getName()));
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPassword(), authorities);
    }

    @Override
    public List<Accounts> getAccounts(String username) {
        return this.accountRepo.getAccounts(username);
    }

    @Override
    public boolean addOrUpdateAccount(Accounts a) {
        
        if (a.getFile() != null) {
            try {
                Map res = this.cloudinary.uploader().upload(a.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                a.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(AccountServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.accountRepo.addOrUpdateAccount(a);
    }

    @Override
    public Accounts getAccountById(int id) {
        return this.accountRepo.getAccountById(id);
    }

    @Override
    public List<Accounts> getAccounts() {
        return this.accountRepo.getAccounts();
    }

    @Override
    public Accounts getAccountByname(String username) {
        return this.accountRepo.getAccountByUsername(username);
    }

    @Override
    public boolean authUser(String username, String password) {
        return this.accountRepo.authUser(username, password);
    }
    
}
