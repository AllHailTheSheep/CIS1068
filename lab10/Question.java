package lab10;

import java.lang.Exception;

public abstract class Question {

    public class DiffucultyException extends Exception {
        public DiffucultyException(String eMessage) {
            super(eMessage);
        }
    }
    
    private static final int MIN_DIF = 1;
    private static final int MAX_DIF = 10;

    private int points, difficulty, answerSpace;
    private String questionText;

    public Question(int points, int difficulty, int answerSpace, String questionText) throws DiffucultyException {
        this.points = points;
        if (difficulty < MIN_DIF || difficulty > MAX_DIF) {
            throw new DiffucultyException(String.format("DiffucultyException: Diffuculty %d is outside "
            + "the acceptable range of %d to %d.", difficulty, MIN_DIF, MAX_DIF));
        } else {
            this.difficulty = difficulty;
        }
        this.answerSpace = answerSpace;
        this.questionText = questionText;
    }

    public int getPoints() {
        return this.points;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    public int getAnswerSpace() {
        return this.answerSpace;
    }

    public String getQuestionText() {
        return this.questionText;
    }
}