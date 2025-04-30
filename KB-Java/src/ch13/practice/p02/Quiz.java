package ch13.practice.p02;

public class Quiz extends Content{
    private String answer;

    public Quiz(String question, String answer) {
        super(question);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
