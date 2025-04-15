package ch04.sec03;

public class SwitchCharExample {
    public static void main(String[] args) {
        char grade = 'B';
        switch(grade) {
            case 'A':
            case 'a':
                break;
            case 'B':
            case 'b':
                break;
            default:
                System.out.println("우수 회원입니다.");
                System.out.println("일반 회원입니다.");
                System.out.println("손님입니다.");
        }
    }
}
