package ch12.practice.p06;

import java.util.Random;
import java.util.Scanner;

public class MatchGame implements VsSelectable {
    protected Celebrity[] candidates;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    // 후보자 동기화 (자식 클래스에서 구현)
    public void initializeCandidates() {

    }

    // 셔플
    public void shuffle() {
        for (int i = candidates.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Celebrity temp = candidates[i];
            candidates[i] = candidates[j];
            candidates[j] = temp;
        }
    }

    // 후보자 출력
    public void printCandidates() {
        for (Celebrity c : candidates) {
            System.out.println(c.getName());
        }
    }

    // selectWinner : 두 사람 중 누가 더 이상형인지 선택 받기
    @Override
    public Celebrity selectWinner(Celebrity c1, Celebrity c2) {
        System.out.println("누가 더 이상형인가요?");
        System.out.println("1. " + c1.getName());
        System.out.println("2. " + c2.getName());

        int choice;
        while (true) {
            System.out.print("선택: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.println("1 또는 2만 입력하세요!");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요!");
            }
        }
        Celebrity winner = (choice == 1) ? c1:c2;
        System.out.println("[" + winner.getName() + " 승리!]");
        return winner;
    }

    // playGame : 경기 진행, 우승자 결정
    public Celebrity playGame() {
        int round = 1;

        while (candidates.length > 1) {
            System.out.println("\n=== " + round + "라운드 ===");
            int nextSize = (candidates.length + 1) / 2;
            Celebrity[] nextRound = new Celebrity[nextSize];
            int nextIndex = 0;

            for (int i = 0; i < candidates.length; i += 2) {
                if (i + 1 >= candidates.length) {
                    System.out.println(candidates[i].getName() + "은(는) 자동으로 다음 라운드 진출!");
                    nextRound[nextIndex++] = candidates[i];
                } else {
                    Celebrity winner = selectWinner(candidates[i], candidates[i + 1]);
                    nextRound[nextIndex++] = winner;
                }
            }

            candidates = nextRound;
            round++;
        }
        System.out.println("\n🏆최종 우승자: " + candidates[0].getName());
        return candidates[0];
    }
}
