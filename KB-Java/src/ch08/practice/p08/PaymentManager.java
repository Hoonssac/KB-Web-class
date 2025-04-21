package ch08.practice.p08;

public class PaymentManager {
    int count;
    int total;
    int CreditCard;
    int KakaoPay;

    public void process(Payment payment, int amount) {
        payment.pay(amount);
        payment.approve();
        payment.cancel("테스트 취소");
        if (payment instanceof KakaoPay) {
            ((KakaoPay) payment).sendNotification();
        } else {
            System.out.println("[알림 서비스 없음]");
        }
    }
}
