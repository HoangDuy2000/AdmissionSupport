/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.repository.Impl;

import com.vhd.pojo.News;
import com.vhd.repository.NewsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
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
@PropertySource("classpath:configs.properties")
public class NewsRepositoryImpl implements NewsRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<News> getNews(Map<String, String> params) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<News> q = b.createQuery(News.class);
        Root r = q.from(News.class);
        q.select(r);
        
        if(params != null){
            List<Predicate> predicates = new ArrayList<>();
            
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(r.get("title"), String.format("%%%s%%", kw)));
            }
            
            String typeNewsId = params.get("typeNewsId");
            if (typeNewsId != null && !typeNewsId.isEmpty()) {
                predicates.add(b.equal(r.get("typesId"), Long.parseLong(typeNewsId)));
            }
            
            q.where(predicates.toArray(Predicate[]::new));
        }
        
        q.orderBy(b.desc(r.get("id")));
        
        Query query = s.createQuery(q);
        
        if(params != null){
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
                query.setMaxResults(pageSize);
                query.setFirstResult((Integer.parseInt(page) - 1) * pageSize);
            }
        }
        
        return query.getResultList();
    }

    @Override
    public int countNews() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT COUNT(*) FROM News");
        
        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean addOrUpdateNews(News n) {
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
    public News getNewsById(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(News.class, id);
    }

    @Override
    public boolean deleteNews(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        News n = this.getNewsById(id);

        try {
            s.delete(n);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
