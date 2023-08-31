/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.formatters;

import com.vhd.pojo.Roles;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author PC
 */
public class RoleFormatter implements Formatter<Roles>{

    @Override
    public String print(Roles roles, Locale locale) {
        return String.valueOf(roles.getId());
    }

    @Override
    public Roles parse(String rolesId, Locale locale) throws ParseException {
        return new Roles(Integer.parseInt(rolesId));
    }
    
}
