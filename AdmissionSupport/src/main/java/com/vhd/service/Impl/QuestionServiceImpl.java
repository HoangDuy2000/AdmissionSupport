/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.service.Impl;

import com.vhd.pojo.Questions;
import com.vhd.repository.QuestionRepository;
import com.vhd.service.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private QuestionRepository questionRepo;

    @Override
    public List<Questions> getQuestion() {
        return this.questionRepo.getQuestion();
    }

    @Override
    public boolean addOrUpdateQuestion(Questions ques) {
        return this.questionRepo.addOrUpdateQuestion(ques);
    }

    @Override
    public Questions getQuestionById(int id) {
        return this.questionRepo.getQuestionById(id);
    }

    @Override
    public boolean deleteQuestion(int id) {
        return this.deleteQuestion(id);
    }

    @Override
    public Questions addQuestion(Questions ques) {
        return this.questionRepo.addQuestion(ques);
    }

    @Override
    public List<Questions> getQuestions(int livesId) {
        return this.questionRepo.getQuestions(livesId);
    }
}
