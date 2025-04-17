package ch07.sec04.exam02;

public class SupersonicAirplane extends Airplane {
    // 상수 선언
    public static final int NORMAL = 1;
    public static final int SUPERSONIC = 2;
    // 상태 필드 선언
    public int flyNode = NORMAL;

    // 메소드 재정의
    @Override
    public void fly() {
        if (flyNode == SUPERSONIC) {
            System.out.println("초음솏 비행합니다.");
        } else {
            // Airplane 객체의 fly() 메소드 호출
            super.fly();
        }
    }
}
