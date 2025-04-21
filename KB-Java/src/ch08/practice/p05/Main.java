package ch08.practice.p05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Payment payment = null;

        for (int i = 0; i < 3; i++) {
            System.out.println("=== 결제 수단을 선택 ===");
            System.out.println("[1] 신용카드");
            System.out.println("[2] 카카오페이");
            System.out.print("결제 수단을 선택하세요: ");
            int pay = sc.nextInt();
            if (pay == 1) {
                payment = new CreditCard();
            } else if (pay == 2) {
                payment = new KakaoPay();
            }

            System.out.print("결제 금액을 입력하세요: ");
            int amount = sc.nextInt();
            boolean isSuccess = payment.pay(amount);

            if (isSuccess) {
                payment.approve();
                payment.cancel("테스트 취소");

                if (payment instanceof KakaoPay) {
                    ((KakaoPay) payment).sendNotification();
                } else {
                    System.out.println("[알림 서비스 없음]");
                }
            } else {
                System.out.println("[결제 실패: 승인/취소 건너뜀]");
            }
            System.out.println();
        }

    }
}
