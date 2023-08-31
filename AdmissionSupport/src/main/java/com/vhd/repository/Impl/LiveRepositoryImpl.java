/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.repository.Impl;

import com.vhd.pojo.Lives;
import com.vhd.repository.LiveRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Repository
@Transactional
public class LiveRepositoryImpl implements LiveRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Autowired
    private Environment env;
    
    @Override
    public List<Lives> getLives() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q= s.createQuery("From Lives");
        
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateLive(Lives l) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (l.getId() == null) {
                s.save(l);
            } else {
                s.update(l);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Lives getLiveById(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Lives.class, id);
    }

    @Override
    public boolean deleteLive(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Lives l = this.getLiveById(id);

        try {
            s.delete(l);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
