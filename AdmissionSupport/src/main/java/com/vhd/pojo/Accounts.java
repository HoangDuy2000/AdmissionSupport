/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author PC
 */
@Entity
@Table(name="accounts")
public class Accounts implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "{accounts.username.notNullErr}")
    private String username;
    @NotNull(message = "{accounts.password.notNullErr}")
    private String password;
    @NotNull(message = "{accounts.firstname.notNullErr}")
    private String first_name;
    @NotNull(message = "{accounts.lastname.notNullErr}")
    private String last_name;
    @NotNull(message = "{accounts.avatar.notNullErr}")
    private String avatar;
    @NotNull(message = "{accounts.email.notNullErr}")
    private String email;
    private boolean active;
    @ManyToOne
    @JoinColumn(name="roles_id")
    private Roles roles;
    @OneToMany(mappedBy = "accountsId")
    @JsonIgnore
    private Set<Questions> questionSet;
    @OneToMany(mappedBy = "accountId")
    @JsonIgnore
    private Set<Comment> commentSet;
    @Transient
    private MultipartFile file;

    public Accounts() {
    }
    
    
    public Accounts(Integer id){
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the roles
     */
    public Roles getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    /**
     * @return the newsSet
     */
    

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the newsSet
    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * @return the questionSet
     */
    public Set<Questions> getQuestionSet() {
        return questionSet;
    }

    /**
     * @param questionSet the questionSet to set
     */
    public void setQuestionSet(Set<Questions> questionSet) {
        this.questionSet = questionSet;
    }

    /**
     * @return the commentSet
     */
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    /**
     * @param commentSet the commentSet to set
     */
    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

}
