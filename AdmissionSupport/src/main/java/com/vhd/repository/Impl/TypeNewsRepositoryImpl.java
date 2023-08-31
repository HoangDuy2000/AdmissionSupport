/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.repository.Impl;

import com.vhd.pojo.TypeNews;
import com.vhd.repository.TypeNewsRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Repository
@Transactional
public class TypeNewsRepositoryImpl implements TypeNewsRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<TypeNews> getTypeNews() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q= s.createQuery("From TypeNews");
        
        return q.getResultList();
    }
    
}
