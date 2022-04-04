package lab10;

public class MultipleChoiceQuestion extends Question {

    private String[] possibleAnswers = new String[5];
    private int correctAnswer;

    public MultipleChoiceQuestion(int points, int difficulty, int answerSpace, String questionText,
                    String[] possibleAnswers, int correctAnswer) throws DiffucultyException {
        super(points, difficulty, answerSpace, questionText);
        this.possibleAnswers = possibleAnswers;
        this.correctAnswer = correctAnswer;
    }

    public int getCorrectAnswer() {
        return this.correctAnswer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getQuestionText());
        sb.append("\n");
        for (int i = 0; i < possibleAnswers.length; i++) {
            sb.append(String.format("\t%d. %s\n", i + 1, possibleAnswers[i]));
        }
        return sb.toString();
    }

    public String answerKeyToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getQuestionText());
        sb.append("\n");
        for (int i = 0; i < possibleAnswers.length; i++) {
            if (i != getCorrectAnswer()) {
                sb.append(String.format("\t%d. %s\n", i + 1, possibleAnswers[i]));
            } else {
                sb.append(String.format("\t%d. **%s**\n", i + 1, possibleAnswers[i]));
            }
        }
        return sb.toString();
    }
}