/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.repository.Impl;

import com.vhd.pojo.Accounts;
import com.vhd.pojo.Questions;
import com.vhd.repository.QuestionRepository;
import com.vhd.service.AccountService;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Repository
@Transactional
public class QuestionRepositoryImpl implements QuestionRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private Environment env;
    
    @Override
    public List<Questions> getQuestion() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q= s.createQuery("From Questions");
        
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateQuestion(Questions ques) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Accounts acc = accountService.getAccountByname(SecurityContextHolder.getContext().getAuthentication().getName());
        ques.setAccountsId(acc);
        try {
            if (ques.getId() == null) {
                ques.setDate(Date.valueOf(LocalDate.now()));
                s.save(ques);
            } else {
                s.update(ques);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Questions getQuestionById(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Questions.class, id);
    }

    @Override
    public boolean deleteQuestion(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Questions ques = this.getQuestionById(id);

        try {
            s.delete(ques);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
