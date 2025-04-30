package ch13.practice.p02;

public class Content {
    private String question;

    public Content(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.toString().equals(question)) {
            return true;
        } else {
            return false;
        }
    }
}
