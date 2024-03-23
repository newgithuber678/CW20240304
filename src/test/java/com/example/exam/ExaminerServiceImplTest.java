package com.example.exam;

import com.example.exam.exceptions.NotEnoughQuestionsException;
import com.example.exam.model.Question;
import com.example.exam.service.ExaminerServiceImpl;
import com.example.exam.service.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    static List<Question> javaQuestions= List.of(
            new Question("question1", "answwwwwwer1"),
            new Question("qeeeeestion2", "answeeeeer2")
    );
    @Mock
    JavaQuestionService javaQuestionService;
    @InjectMocks
    ExaminerServiceImpl examinerServiceImpl;

    @Test
    void testNotEnoughQuestions() {
        assertThrows(NotEnoughQuestionsException.class,()->examinerServiceImpl.getQuestions(100));
    }
}
