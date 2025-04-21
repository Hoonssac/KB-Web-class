package ch08.sec06;

import ch08.sec06.RemoteControl;

public class RemoteControlExample {
    public static void main(String[] args) {
        // 인터페이스 변수 선언
        RemoteControl rc;

        rc = new Audio();
        rc.turnOn();
        rc.setVolume(5);

        // 디폴트 메소드 호출
        rc.setMute(true);
        rc.setMute(false);

        // 정적 메소드 호출
        RemoteControl.changeBattery();
    }
}
