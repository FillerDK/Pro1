package ex3b.model;

public class MultipleChoiceTest {
    private static char[] correctAnswers = new char[] {'A', 'D', 'C', 'A', 'B', 'D', 'C', 'D', 'A', 'A'};

    public static char[] getRandomAnswers() {
        char[] answers = new char[10];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = (char) ('A' + (int) (Math.random() * 4));
        } return answers;
    }

    public static char[] getCorrectAnswers() {
        return correctAnswers;
    }
}
