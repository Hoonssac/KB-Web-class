package ch08.practice.p08;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Payment payment = null;
        PaymentManager pm = new PaymentManager();

        while (true) {
            System.out.println("=== 유니페이 결제 시스템 ===");
            System.out.println("[1] 신용카드");
            System.out.println("[2] 카카오페이");
            System.out.println("[0] 종료");
            System.out.print("결제 수단을 선택하세요: ");
            int pay = sc.nextInt();

            // 종료 조건
            if (pay == 0) {
                System.out.println();
                System.out.println("✅ 결제 통계 요약");
                System.out.println("총 결제 횟수: " + pm.count + "회");
                System.out.println("총 결제 금액: " + pm.total + "원");
                System.out.println("[CreditCard] : " + pm.CreditCard + "건");
                System.out.println("[KakaoPay] : " + pm.KakaoPay + "건");
                break;
            }

            int amount = 0;
            if (pay == 1) {
                payment = new CreditCard();
            } else if (pay == 2) {
                payment = new KakaoPay();
                System.out.println("[카카오페이 사용자 인증을 진행하시곘습니까? (y/n)] ");
                System.out.print(">> ");
                char input = sc.next().charAt(0);
                System.out.println("[카카오페이] 결제를 준비합니다...");
                if (input == 'y') {
                    payment.authenticate();
                }
            }

            if (!payment.beforePay()) {
                System.out.println("[결제 실패: 준비 단계에서 중단]");
            } else {
                System.out.print("결제 금액을 입력하세요: ");
                amount = sc.nextInt();
                pm.process(payment, amount);
                pm.count++;
                pm.total += amount;
                if (payment instanceof KakaoPay) {
                    pm.KakaoPay++;
                } else if (payment instanceof CreditCard) {
                    pm.CreditCard++;
                }
            }
            System.out.println();
        }

    }
}
