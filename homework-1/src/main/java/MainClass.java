import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.QuestionService;

public class MainClass {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-context.xml");

        QuestionService questionService = context.getBean(QuestionService.class);

        questionService.start();
    }
}
