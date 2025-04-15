package ch05.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int balance = 0;

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("---------------------------------");
            System.out.print("선택> ");
            int input = Integer.parseInt(br.readLine());

            if (input == 4) {
                System.out.println();
                System.out.println("프로그램 종료");
                break;
            } else {
                int money = 0;
                switch (input) {
                    case 1:
                        System.out.print("예금액>");
                        money = Integer.parseInt(br.readLine());
                        balance += money;
                        break;
                    case 2:
                        System.out.print("출금액>");
                        money = Integer.parseInt(br.readLine());
                        balance -= money;
                        break;
                    case 3:
                        System.out.println("잔고>" + balance);
                        break;
                }
                System.out.println();
            }
        }
    }
}
