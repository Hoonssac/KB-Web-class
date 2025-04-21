package ch08.practice.p07;

public class CreditCard implements Payment {
    int amount;

    @Override
    public boolean pay(int amount) {
        System.out.println("[신용카드] " + amount + "원 결제 완료");
        Payment.log("결제 수단: [CreditCard], 금액: " + amount + "원");
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

    @Override
    public void authenticate() {

    }

    @Override
    public boolean beforePay() {
        System.out.println("[신용카드] 결제를 준비합니다...");
        return true;
    }

    public void sendNotification() {
        System.out.println("[알림 서비스 없음]");
    }

}
