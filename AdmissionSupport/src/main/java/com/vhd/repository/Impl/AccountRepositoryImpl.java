/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.repository.Impl;

import com.vhd.pojo.Accounts;
import com.vhd.repository.AccountRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Repository
@Transactional
public class AccountRepositoryImpl implements AccountRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Accounts getAccountByUsername(String username) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Accounts Where username=:un");
        q.setParameter("un", username);
        
        return (Accounts) q.getSingleResult();
    }

    @Override
    public List<Accounts> getAccounts(String username) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Accounts> q = b.createQuery(Accounts.class);
        Root r = q.from(Accounts.class);
        q.select(r);
        
        if (!username.isEmpty()) {
            Predicate p = b.equal(r.get("username").as(String.class), username.trim());
            q = q.where(p);
        }
        
        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean addOrUpdateAccount(Accounts a) {
         Session s = this.sessionFactory.getObject().getCurrentSession();
         String pass = a.getPassword();
        
        try {
            if (a.getId() == null) {
                a.setPassword(this.passwordEncoder.encode(pass));
                s.save(a);
            } else {
                s.update(a);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Accounts getAccountById(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Accounts.class, id);
    }

    @Override
    public List<Accounts> getAccounts() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q= s.createQuery("From Accounts");
        
        return q.getResultList();
    }

    @Override
    public Accounts getAccountByname(String username) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Accounts.class, username);
    }

    @Override
    public boolean authUser(String username, String password) {
        Accounts u = this.getAccountByUsername(username);


        return this.passwordEncoder.matches(password, u.getPassword());
    }

    @Override
    public Accounts addAccount(Accounts account) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        s.save(account);

        return account;
    }
    
}
