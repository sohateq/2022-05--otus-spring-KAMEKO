package service;

import entity.Answer;
import entity.Question;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor

public class QuestionServiceImpl implements QuestionService {

    private final QuestionScreen questionScreen;
    private final String resPath;

    public void start() {
        File file = loadQuestionsFile(resPath);
        questionScreen.showQuestions(getQuestionList(file));
    }

    private File loadQuestionsFile(String resPath) {
        File file = null;
        try {
            file = ResourceUtils.getFile(resPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return file;
    }

    private List<Question> getQuestionList( File file) {
        List<Question> questions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                Question q = new Question();
                q.setText(values[0]);

                List<Answer> answers = new ArrayList<>();
                for (int i = 1; i < values.length; i++ ) {
                    answers.add(new Answer(values[i]));
                }

                q.setVariants(answers);

                questions.add(q);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return questions;
    }
}
