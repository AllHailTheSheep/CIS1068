package lab10;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import lab10.Question.DiffucultyException;

public class QuestionTests {
    public static void main(String[] args) throws DiffucultyException {
        try {
            @SuppressWarnings("unused")
            ObjectiveQuestion test_throws = new ObjectiveQuestion(1, 11, 1, "What is 1 + 1?", "2");
        } catch (DiffucultyException e) {
            System.err.println("Error: " + e.getMessage());
        }

        ObjectiveQuestion obQ1 = new ObjectiveQuestion(1, 10, 1, "What is 1 + 1?", "2");
        System.out.println(obQ1.toString());
        System.out.println(obQ1.answerKeyToString());

        FillInTheBlankQuestion fitbQ1 = new FillInTheBlankQuestion(5, 5, 4, "Java was originally called _ .", "Oak");
        System.out.println(fitbQ1.toString());
        System.out.println(fitbQ1.answerKeyToString());

        String[] answers = {"George Washington", "Abraham Lincoln", "Theodore Roosevelt", "Herbert Hoover"};
        MultipleChoiceQuestion mcQ1 = new MultipleChoiceQuestion(1, 1, 1, "Who signed the Emancipation Proclamation?", answers, 1);
        System.out.println(mcQ1.toString());
        System.out.println(mcQ1.answerKeyToString());

        ArrayList<Object> questions = new ArrayList<Object>();
        questions.add(obQ1);
        questions.add(fitbQ1);
        questions.add(mcQ1);
        Test test1 = new Test(questions);
        test1.addQuestion(new ObjectiveQuestion(1, 2, 3, "What animal is the Temple mascot?", "Owl"));
        System.out.println(test1.toString());
        System.out.println(test1.answerKeyToString());
        try {
            test1.writeTestToFile(new File("./test1.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            test1.writeAnswerKeyToFile(new File("./test1key.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}