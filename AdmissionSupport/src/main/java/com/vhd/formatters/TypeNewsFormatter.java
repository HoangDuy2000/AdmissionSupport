/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.formatters;

import com.vhd.pojo.TypeNews;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author PC
 */
public class TypeNewsFormatter implements Formatter<TypeNews>{

    @Override
    public String print(TypeNews typeNews, Locale locale) {
        return String.valueOf(typeNews.getId());
    }

    @Override
    public TypeNews parse(String typeNewsId, Locale locale) throws ParseException {
        return new TypeNews(Integer.parseInt(typeNewsId));
    }
    
}
