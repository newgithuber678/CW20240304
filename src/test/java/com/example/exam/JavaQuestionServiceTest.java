package com.example.exam;

import com.example.exam.exceptions.NotFoundQuestionsException;
import com.example.exam.model.Question;
import com.example.exam.service.JavaQuestionService;
import com.example.exam.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    QuestionService questionService;
    @InjectMocks
    JavaQuestionService javaQuestionService;

    @Test
    void testAdd() {
        javaQuestionService.add("question1", "answwwwwwer1");
        javaQuestionService.add("qeeeeestion2", "answeeeeer2");
        assertThat(javaQuestionService.getAll()).containsExactlyInAnyOrder(
                new Question("question1", "answwwwwwer1"),
                new Question("qeeeeestion2", "answeeeeer2")
        );
    }

    @Test
    void testRemove() {
        javaQuestionService.add("question1", "answwwwwwer1");
        javaQuestionService.add("qeeeeestion2", "answeeeeer2");
        var removed = javaQuestionService.remove(new Question("question1", "answwwwwwer1"));
        assertThat(removed).isEqualTo(new Question("question1", "answwwwwwer1"));
        assertThat(javaQuestionService.remove(new Question("que", "an"))).isNull();
        assertThat(javaQuestionService.getAll()).containsExactlyInAnyOrder(
                new Question("qeeeeestion2", "answeeeeer2")
        );
    }

    @Test
    void testGetRandomQuestion() {
        assertThrows(NotFoundQuestionsException.class, () -> javaQuestionService.getRandomQuestion());
        javaQuestionService.add("question1", "answwwwwwer1");
        javaQuestionService.add("qeeeeestion2", "answeeeeer2");
        javaQuestionService.add("qu3stion", "answ3r");
        javaQuestionService.add("qeeee4est", "4answee");
        assertThat(javaQuestionService.getRandomQuestion()).isIn(
                new Question("question1", "answwwwwwer1"),
                new Question("qeeeeestion2", "answeeeeer2"),
                new Question("qu3stion", "answ3r"),
                new Question("qeeee4est", "4answee")
        );
    }
}
