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
import com.vhd.pojo.Roles;
import com.vhd.repository.AccountRepository;
import com.vhd.service.AccountService;
import com.vhd.service.RoleService;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author PC
 */
@Service("userDetailService")
public class AccountServiceImpl implements AccountService{
    
    @Autowired
    private AccountRepository accountRepo;
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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

    @Override
    public Accounts addAccount(Map<String, String> params, MultipartFile avatar) {
        Accounts u = new Accounts();
        
        u.setFirst_name(params.get("firstName"));
        u.setLast_name(params.get("lastName"));
        u.setEmail(params.get("email"));
        u.setUsername(params.get("username"));
        u.setPassword(this.passwordEncoder.encode(params.get("password")));
        u.setRoles(roleService.getRoles().get(3));
        if (!avatar.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(avatar.getBytes(), 
                        ObjectUtils.asMap("resource_type", "auto"));
                u.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(AccountServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.accountRepo.addAccount(u);
        return u;
    }
    
}
