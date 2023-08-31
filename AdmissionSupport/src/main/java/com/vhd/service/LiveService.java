/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.service;

import com.vhd.pojo.Lives;
import java.util.List;

/**
 *
 * @author PC
 */
public interface LiveService {
    List<Lives> getLives();
    boolean addOrUpdateLive(Lives l);
    Lives getLiveById(int id);
    boolean deleteLive(int id);
}
