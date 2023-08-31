/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.service.Impl;

import com.vhd.pojo.Lives;
import com.vhd.repository.LiveRepository;
import com.vhd.service.LiveService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class LiveServiceImpl implements LiveService{
    @Autowired
    private LiveRepository liveRepo;
    
    @Override
    public List<Lives> getLives() {
        return this.liveRepo.getLives();
    }

    @Override
    public boolean addOrUpdateLive(Lives l) {
        return this.liveRepo.addOrUpdateLive(l);
    }

    @Override
    public Lives getLiveById(int id) {
        return this.liveRepo.getLiveById(id);
    }

    @Override
    public boolean deleteLive(int id) {
        return this.liveRepo.deleteLive(id);
    }
    
}
