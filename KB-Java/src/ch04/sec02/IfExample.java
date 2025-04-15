package ch04.sec02;

public class IfExample {
    public static void main(String[] args) {
        int score = 93;
        if(score >= 90) {
            System.out.println("점수가 90보다 큽니다.");
            System.out.println("등급은 A입니다.");
        }
        if(score < 90)
            System.out.println("점수가 90보다 작습니다.");
        // 중괄호 생략시 한 문장까지만 if문 안에 속한다.
            System.out.println("등급은 B입니다."); // if문과는 상관없는 실행문
    }
}
