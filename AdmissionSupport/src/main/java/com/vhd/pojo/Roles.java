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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name="roles")
public class Roles implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<Accounts> accountsSet;

    public Roles() {
    }

    public Roles(Integer id) {
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the accountsSet
     */
    public Set<Accounts> getAccountsSet() {
        return accountsSet;
    }

    /**
     * @param accountsSet the accountsSet to set
     */
    public void setAccountsSet(Set<Accounts> accountsSet) {
        this.accountsSet = accountsSet;
    }
}
