package lab10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    private List<Object> questions = new ArrayList<Object>();
    private int totalPoints;

    public Test(List<Object> questions) {
        this.questions = questions;
        for (Object question : questions) {
            this.totalPoints += ((Question) question).getPoints();
        }
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
        this.totalPoints += question.getPoints();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Test: worth %d points\n\n", totalPoints));
        for (int i = 0; i < questions.size(); i++) {
            sb.append(String.format("%d: %s\n", i + 1, this.questions.get(i).toString()));
        }
        return sb.toString();
    }

    public String answerKeyToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Test: worth %d points\n\n", totalPoints));
        for (int i = 0; i < this.questions.size(); i++) {
            String answer = null;
            if (this.questions.get(i) instanceof ObjectiveQuestion) {
                answer = ((ObjectiveQuestion) this.questions.get(i)).answerKeyToString();
            } else if (this.questions.get(i) instanceof FillInTheBlankQuestion) {
                answer = ((FillInTheBlankQuestion) this.questions.get(i)).answerKeyToString();
            } else if (this.questions.get(i) instanceof MultipleChoiceQuestion) {
                answer = ((MultipleChoiceQuestion) this.questions.get(i)).answerKeyToString();
            } else {
                System.err.println(String.format("Object at index %d is an unknown question type!", i));
                System.exit(1);
            }
            sb.append(String.format("%d: %s\n", i + 1, answer));
        }
        return sb.toString();
    }

    public void writeTestToFile(File file) throws IOException {
        try {
            if (file.exists()) {
                System.err.println("File already exists. Aborting.");
                System.exit(1);
            } else {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("An error occured. Aborting.");
            e.printStackTrace();
            System.exit(1);
        }
        FileWriter writer = new FileWriter(file.getAbsolutePath());
        writer.write(toString());
        writer.close();
    }

    public void writeAnswerKeyToFile(File file) throws IOException {
        try {
            if (file.exists()) {
                System.err.println("File already exists. Aborting.");
                System.exit(1);
            } else {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("An error occured. Aborting.");
            e.printStackTrace();
            System.exit(1);
        }
        FileWriter writer = new FileWriter(file.getAbsolutePath());
        writer.write(answerKeyToString());
        writer.close();
    }
}