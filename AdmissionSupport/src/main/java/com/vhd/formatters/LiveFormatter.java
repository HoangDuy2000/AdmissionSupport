/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.formatters;

import com.vhd.pojo.Lives;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author PC
 */
public class LiveFormatter implements Formatter<Lives>{

    @Override
    public String print(Lives live, Locale locale) {
        return String.valueOf(live.getId());
    }

    @Override
    public Lives parse(String liveId, Locale locale) throws ParseException {
        return new Lives(Integer.parseInt(liveId));
    }
    
}
