/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.repository.Impl;

import com.vhd.pojo.Facultys;
import com.vhd.repository.FacultyRepository;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class FacultyRepositoryImpl implements FacultyRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Autowired
    private Environment env;

    @Override
    public List<Facultys> getFacultys() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q= s.createQuery("From Facultys");
        
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateFaculty(Facultys f) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (f.getId() == null) {
                f.setCreatedDate(Date.valueOf(LocalDate.now()));
                s.save(f);
            } else {
                s.update(f);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Facultys getFacultyById(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Facultys.class, id);
    }

    @Override
    public boolean deleteFaculty(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Facultys f = this.getFacultyById(id);

        try {
            s.delete(f);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
