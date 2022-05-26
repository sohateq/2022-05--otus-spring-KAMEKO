package service;

import entity.Question;

import java.io.File;
import java.util.List;

public interface QuestionScreen {
    void showQuestions(List<Question> questions);
}
