/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.formatters;

import com.vhd.pojo.Facultys;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author PC
 */
public class FacultyFormatter implements Formatter<Facultys>{

    @Override
    public String print(Facultys faculty, Locale locale) {
        return String.valueOf(faculty.getId());
    }

    @Override
    public Facultys parse(String facultyId, Locale locale) throws ParseException {
        return new Facultys(Integer.parseInt(facultyId));
    }
    
}
