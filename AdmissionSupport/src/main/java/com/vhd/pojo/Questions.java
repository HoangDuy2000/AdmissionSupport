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
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "questions")
public class Questions implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "lives_id", referencedColumnName = "id")
    private Lives livesId;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Accounts accountsId;

    public Questions() {
    }
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
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

    /**
     * @return the lives
     */
    public Lives getLives() {
        return getLivesId();
    }

    /**
     * @param lives the lives to set
     */
    public void setLives(Lives lives) {
        this.setLivesId(lives);
    }

    /**
     * @return the livesId
     */
    public Lives getLivesId() {
        return livesId;
    }

    /**
     * @param livesId the livesId to set
     */
    public void setLivesId(Lives livesId) {
        this.livesId = livesId;
    }

    /**
     * @return the accountsId
     */
    public Accounts getAccountsId() {
        return accountsId;
    }

    /**
     * @param accountsId the accountsId to set
     */
    public void setAccountsId(Accounts accountsId) {
        this.accountsId = accountsId;
    }
}
