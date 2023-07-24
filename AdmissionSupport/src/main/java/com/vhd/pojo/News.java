/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "news")
public class News implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeNews typesId;
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Facultys facultysId;
    @ManyToOne
    @JoinColumn(name = "acount_id")
    private Accounts accountsId;
    @OneToMany(mappedBy = "newsId")
    private Set<ChatNews> chatnewsSet;

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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @return the typesId
     */
    public TypeNews getTypesId() {
        return typesId;
    }

    /**
     * @param typesId the typesId to set
     */
    public void setTypesId(TypeNews typesId) {
        this.typesId = typesId;
    }

    /**
     * @return the facultysId
     */
    public Facultys getFacultysId() {
        return facultysId;
    }

    /**
     * @param facultysId the facultysId to set
     */
    public void setFacultysId(Facultys facultysId) {
        this.facultysId = facultysId;
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

    /**
     * @return the chatnewsSet
     */
    public Set<ChatNews> getChatnewsSet() {
        return chatnewsSet;
    }

    /**
     * @param chatnewsSet the chatnewsSet to set
     */
    public void setChatnewsSet(Set<ChatNews> chatnewsSet) {
        this.chatnewsSet = chatnewsSet;
    }

}
