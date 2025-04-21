package ch08.practice.p02;

public interface Payment {
    void pay(int amount); // 금액을 결제하는 기능
    void approve(); // 결제를 승인하는 기능
    void cancel(String reason);
}