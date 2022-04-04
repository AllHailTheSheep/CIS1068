package lab10;

public class ObjectiveQuestion extends Question {

    private String correctAnswer;

    public ObjectiveQuestion(int points, int difficulty, int answerSpace, String questionText, String correctAnswer)
            throws DiffucultyException {
        super(points, difficulty, answerSpace, questionText);
        this.correctAnswer = correctAnswer;
    }
    
    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s ", getQuestionText()));
        for (int i = 0; i < getAnswerSpace(); i++) {
            sb.append("_");
        }
        sb.append("\n");
        return sb.toString();
    }

    public String answerKeyToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s\n", getQuestionText(), getCorrectAnswer()));
        return sb.toString();
    }
}