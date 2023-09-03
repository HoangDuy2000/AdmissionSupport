/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.service;

import com.vhd.pojo.Questions;
import java.util.List;

/**
 *
 * @author PC
 */
public interface QuestionService {
    List<Questions> getQuestion();
    boolean addOrUpdateQuestion(Questions ques);
    Questions getQuestionById(int id);
    boolean deleteQuestion(int id);
    Questions addQuestion (Questions ques);
    List<Questions> getQuestions(int livesId);
}
