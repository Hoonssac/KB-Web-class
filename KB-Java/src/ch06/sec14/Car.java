package ch06.sec14;

public class Car {
    // 필드 선언
    private int speed;
    private boolean stop;

//    // 생성자
//    public Car(int speed, boolean stop) {
//        this.speed = speed;
//        this.stop = stop;
//    }

    // getter/setter
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed < 0) {
            this.speed = 0;
            return;
        }
        this.speed = speed;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
        if (stop == true) {
            this.speed = 0;
        }
    }
}
