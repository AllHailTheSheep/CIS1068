package lab10;

public class FillInTheBlankQuestion extends Question {

    private int answerIndex;
    private String correctAnswer;
    private String[] words;

    public FillInTheBlankQuestion(int points, int difficulty, int answerSpace, String questionText, String correctAnswer)
            throws DiffucultyException {
        super(points, difficulty, answerSpace, questionText);
        this.correctAnswer = correctAnswer;
        initAnswerIndex();
    }
    
    private void initAnswerIndex() {
        this.words = getQuestionText().split("\s+");
        for (int i = 0; i < this.words.length; i++) {
            if (words[i].charAt(0) == '_') {
                this.answerIndex = i;
                break;
            }
        }
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public int getAnswerIndex() {
        return this.answerIndex;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getAnswerIndex(); i++) {
            sb.append(words[i] + " ");
        }
        for (int i = 0; i < getAnswerSpace(); i++) {
            sb.append("_");
        }
        for (int i = getAnswerIndex() + 1; i < words.length; i++) {
            if (i == getAnswerIndex() + 1) {
                sb.append(" ");
            }
            if (i < words.length) {
                sb.append(words[i] + " ");
            } else {
                sb.append(words[i]);
            }
        }
        sb.append("\n");
        return sb.toString();
    }

    public String answerKeyToString() {
        int len = getCorrectAnswer().length();
        int underscores = (getAnswerSpace() - len) / 2  > 0 ? (getAnswerSpace() - len) / 2 : 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getAnswerIndex(); i++) {
            sb.append(words[i] + " ");
        }
        for (int i = 0; i < underscores; i++) {
            sb.append("_");
        }
        sb.append(getCorrectAnswer());
        for (int i = 0; i < underscores; i++) {
            sb.append("_");
        }
        sb.append(" ");
        for (int i = getAnswerIndex() + 1; i < words.length; i++) {
            if (i < words.length) {
                sb.append(words[i] + " ");
            } else {
                sb.append(words[i]);
            }
        }
        sb.append("\n");
        return sb.toString();
    }

}