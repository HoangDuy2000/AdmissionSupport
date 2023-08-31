/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.repository.Impl;

import com.vhd.pojo.Scores;
import com.vhd.repository.ScoreRepository;
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
public class ScoreRepositoryImpl implements ScoreRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Autowired
    private Environment env;
    
    @Override
    public List<Scores> getScores() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q= s.createQuery("From Scores");
        
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateScore(Scores n) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (n.getId() == null) {
                s.save(n);
            } else {
                s.update(n);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Scores getScoreById(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Scores.class, id);
    }

    @Override
    public boolean deleteScore(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Scores score = this.getScoreById(id);

        try {
            s.delete(score);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
