package com.example.exam.service;

import com.example.exam.exceptions.NotEnoughQuestionsException;
import com.example.exam.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        var allQuestions = questionService.getAll();
        if (amount > allQuestions.size()) {
            throw new NotEnoughQuestionsException();
        }
        if (amount == allQuestions.size()) {
            return allQuestions;
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            var randomQuestion = questionService.getRandomQuestion();
            questions.add(randomQuestion);
        }

        return questions;
    }

}
