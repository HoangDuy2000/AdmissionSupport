/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.repository;

import com.vhd.pojo.Scores;
import java.util.List;

/**
 *
 * @author PC
 */
public interface ScoreRepository {
    List<Scores> getScores();
    boolean addOrUpdateScore(Scores n);
    Scores getScoreById(int id);
    boolean deleteScore(int id);
    List<Scores> getScores(int facultysId);
}
