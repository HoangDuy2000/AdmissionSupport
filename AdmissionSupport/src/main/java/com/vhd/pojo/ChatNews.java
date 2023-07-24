/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "chats_news")
public class ChatNews implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "news_id", referencedColumnName = "id")
    @ManyToOne
    private News newsId;
    @JoinColumn(name = "chats_id", referencedColumnName = "id")
    @ManyToOne
    private Chats chatId;
    private Date date;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the news
     */
    public News getNews() {
        return newsId;
    }

    /**
     * @param news the news to set
     */
    public void setNews(News news) {
        this.newsId = news;
    }

    /**
     * @return the chat
     */
    public Chats getChat() {
        return chatId;
    }

    /**
     * @param chat the chat to set
     */
    public void setChat(Chats chat) {
        this.chatId = chat;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
