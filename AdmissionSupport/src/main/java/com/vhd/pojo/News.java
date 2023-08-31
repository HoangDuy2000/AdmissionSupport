/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "news")
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @NotNull(message = "{news.title.notNullMsg}")
    @Size(min = 10, max = 500, message = "{news.title.lenErr}")
    private String title;
    @Size(min = 10, max = 1000, message = "{news.content.lenErr}")
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private TypeNews typesId;
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Facultys facultysId;

    public News() {
    }

    public News(Integer id) {
        this.id = id;
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
     * @return the chatnewsSet
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
