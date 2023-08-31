/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.repository;

import com.vhd.pojo.News;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
public interface NewsRepository {
    List<News> getNews(Map<String, String> params);
    int countNews();
    boolean addOrUpdateNews(News n);
    News getNewsById(int id);
    boolean deleteNews(int id);
}
