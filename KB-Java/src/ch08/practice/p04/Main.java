package ch08.practice.p04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Payment[] payments = {
                new CreditCard(),
                new KakaoPay(),
                new KakaoPay(),
                new CreditCard()
        };

        for (int i = 0; i < payments.length; i++) {
            System.out.println("[" + (i+1) + "번 결제수단] 결제 금액을 입력하세요: ");
            System.out.print(">> ");
            int amount = sc.nextInt();
            boolean isSuccess = payments[i].pay(amount);
            if (isSuccess) {
                payments[i].approve();
                payments[i].cancel("테스트 취소");
            } else {
                System.out.println("[결제 실패: 승인/취소 건너뜀]");
            }
            System.out.println();
        }
    }
}
