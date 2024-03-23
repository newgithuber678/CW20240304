package com.example.exam.service;

import com.example.exam.model.Question;

import java.util.Collection;
import java.util.List;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
