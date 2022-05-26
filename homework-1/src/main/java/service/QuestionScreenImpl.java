package service;

import entity.Answer;
import entity.Question;

import java.util.List;

public class QuestionScreenImpl implements QuestionScreen {

    public void showQuestions(List<Question> questionList) {
        for(Question q: questionList) {
            System.out.println(q.getText());

            for (Answer a: q.getVariants()) {
                System.out.println("   •" + a.getText());
            }
        }
    }
}
