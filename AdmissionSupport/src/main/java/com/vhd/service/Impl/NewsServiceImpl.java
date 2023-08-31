/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.service.Impl;

import com.vhd.pojo.News;
import com.vhd.repository.NewsRepository;
import com.vhd.service.NewsService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsRepository newsRepo;

    @Override
    public List<News> getNews(Map<String, String> params) {
        return this.newsRepo.getNews(params);
    }

    @Override
    public int countNews() {
        return this.newsRepo.countNews();
    }

    @Override
    public boolean addOrUpdateNews(News n) {
        return this.newsRepo.addOrUpdateNews(n);
    }

    @Override
    public News getNewsById(int id) {
        return this.newsRepo.getNewsById(id);
    }

    @Override
    public boolean deleteNews(int id) {
        return this.newsRepo.deleteNews(id);
    }
}
