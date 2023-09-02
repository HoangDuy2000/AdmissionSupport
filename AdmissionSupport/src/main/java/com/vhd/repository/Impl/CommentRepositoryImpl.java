/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.repository.Impl;

import com.vhd.pojo.Comment;
import com.vhd.repository.CommentRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
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
public class CommentRepositoryImpl implements CommentRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Comment> getComments(int newsId) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Comment Where product.id=:id");
        q.setParameter("id", newsId);

        return q.getResultList();
    }

    @Override
    public Comment addComment(Comment c) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.save(c);
            return c;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
