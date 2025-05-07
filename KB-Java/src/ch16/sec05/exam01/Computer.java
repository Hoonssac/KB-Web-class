package ch16.sec05.exam01;

public class Computer {
    // 정적 메소드
    public static double staticMethod(double x, double y) {
        return x + y;
    }

    // 인스턴스 메소드
    public double instanceMethod(double x, double y) {
        return x * y;
    }

    // 두 메소드 다 action에 넣어서 사용할 것이기 때문에, calc의 형태를 따른다.
}
