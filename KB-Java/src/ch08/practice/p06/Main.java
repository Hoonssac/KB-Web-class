package ch08.practice.p06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Payment payment = null;

        for (int i = 0; i < 3; i++) {
            System.out.println("=== 유니페이 결제 시스템 ===");
            System.out.println("[1] 신용카드");
            System.out.println("[2] 카카오페이");
            System.out.print("결제 수단을 선택하세요: ");
            int pay = sc.nextInt();
            if (pay == 1) {
                payment = new CreditCard();
            } else if (pay == 2) {
                payment = new KakaoPay();
                System.out.print("[카카오페이 사용자 인증을 진행하시곘습니까? (y/n)] ");
                char input = sc.next().charAt(0);
                if (input == 'y') {
                    payment.authenticate();
                }
            }

            if (!payment.beforePay()) {
                System.out.println("[결제 실패: 준비 단계에서 중단]");
            }
            else {
                System.out.print("결제 금액을 입력하세요: ");
                int amount = sc.nextInt();
                payment.pay(amount);
                payment.approve();
                payment.cancel("테스트 취소");
                payment.sendNotification();
            }


            System.out.println();
        }

    }
}
