package ch08.practice.p04;

public class CreditCard implements Payment {
    int amount;

    @Override
    public boolean pay(int amount) {
        System.out.println("[신용카드] " + amount + "원 결제 완료");
        this.amount = amount;
        return true;
    }

    @Override
    public void approve() {
        System.out.println("[신용카드] 카드 승인 완료");
    }

    @Override
    public void cancel(String reason) {
        System.out.println("[신용카드] " + amount + "원 결제 취소 - 사유: " + reason);
    }
}
