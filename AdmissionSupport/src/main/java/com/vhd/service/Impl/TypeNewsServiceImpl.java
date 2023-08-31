/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.service.Impl;

import com.vhd.pojo.TypeNews;
import com.vhd.repository.TypeNewsRepository;
import com.vhd.service.TypeNewsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class TypeNewsServiceImpl implements TypeNewsService{
    
    @Autowired
    private TypeNewsRepository typeNewsRepo;
    
    @Override
    public List<TypeNews> getTypeNews() {
        return this.typeNewsRepo.getTypeNews();
    }
    
}
