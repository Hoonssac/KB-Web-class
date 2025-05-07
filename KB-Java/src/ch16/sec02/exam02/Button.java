package ch16.sec02.exam02;

public class Button {
    // 정적 중첩 함수형 인터페이스
    @FunctionalInterface
    public static interface ClickListneer {
        // 추상 메소드
        void onClick();
    }

    // 필드
    private ClickListneer clickListneer;

    // 메소드
    public void setClickListener(ClickListneer clickListneer) {
        this.clickListneer = clickListneer;
    }

    public void click() {
        this.clickListneer.onClick();
    }
}
