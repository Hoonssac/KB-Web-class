package ch08.practice.p03;

public class Main {
    public static void main(String[] args) {
        Payment payment = new KakaoPay();
        payment.pay(3000);       // 실패 케이스
        payment.pay(7000);       // 성공 케이스
        payment.approve();
        payment.cancel("오입력");
    }
}
