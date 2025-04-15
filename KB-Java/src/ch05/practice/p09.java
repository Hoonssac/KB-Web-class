package ch05.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] scores = null;

        while (true) {
            System.out.println("---------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("----------------------------");
            System.out.print("선택> ");
            int input = Integer.parseInt(br.readLine());
            if (input == 5) {
                System.out.println("프로그램 종료");
                break;
            } else {
                switch (input) {
                    case 1:
                        System.out.print("학생수> ");
                        scores = new int[Integer.parseInt(br.readLine())];
                        break;
                    case 2:
                        for (int i = 0; i < scores.length; i++) {
                            System.out.print("scores[" + i + "]> ");
                            scores[i] = Integer.parseInt(br.readLine());
                        }
                        break;
                    case 3:
                        for (int i = 0; i < scores.length; i++) {
                            System.out.println("scores[" + i + "]: " + scores[i]);
                        }
                        break;
                    case 4:
                        int max = 0;
                        int total = 0;
                        for (int score : scores) {
                            if (score > max) {
                                max = score;
                            }
                            total += score;
                        }
                        System.out.println("최고 점수: " + max);
                        System.out.printf("평균 점수: %.1f%n", (double) total / scores.length);
                        break;
                }
            }
        }

    }
}
