/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.service.Impl;

import com.vhd.pojo.Scores;
import com.vhd.repository.ScoreRepository;
import com.vhd.service.ScoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    private ScoreRepository scoreRepo;

    @Override
    public List<Scores> getScores() {
        return this.scoreRepo.getScores();
    }

    @Override
    public boolean addOrUpdateScore(Scores n) {
        return this.scoreRepo.addOrUpdateScore(n);
    }

    @Override
    public Scores getScoreById(int id) {
        return this.scoreRepo.getScoreById(id);
    }

    @Override
    public boolean deleteScore(int id) {
        return this.scoreRepo.deleteScore(id);
    }

    @Override
    public List<Scores> getScores(int facultysId) {
        return this.scoreRepo.getScores(facultysId);
    }
}
