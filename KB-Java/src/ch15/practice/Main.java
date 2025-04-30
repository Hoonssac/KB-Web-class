package ch15.practice;

import ch12.practice.p08.HistoryManager;
import ch15.practice.history.DollHistoryManager;
import ch15.practice.queue.DollQueueManager;
import ch15.practice.stack.DollStackManager;
import ch15.practice.util.RandomCustomerProvider;

import java.util.Scanner;

// 메뉴 출력, 사용자 입력 처리, 전체 흐름 관리
public class Main {
    public static RandomCustomerProvider randomCustomerProvider = new RandomCustomerProvider();
    public static DollQueueManager dollQueueManager = new DollQueueManager();
    public static DollStackManager dollStackManager = new DollStackManager();
    public static DollHistoryManager dollHistoryManager = new DollHistoryManager();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.println("=== 인형뽑기 가게 ===");
            System.out.println(
                            "[1] 고객 등록\n" +
                            "[2] 뽑기 진행 (인형 보관)\n" +
                            "[3] 현재 대기열 보기\n" +
                            "[4] 보관함 보기\n" +
                                    "[5] 고객별 인형 기록 보기\n" +
                                    "[6] 중복 제거된 인형 목록 보기\n" +
                            "[0] 종료"
            );
            System.out.print("선택 >> ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    String input = randomCustomerProvider.getRandomCustomer();
                    dollQueueManager.registerCustomer(input);
                    System.out.println();
                    break;
                case 2:
                    dollQueueManager.getNextCustomer();
                    System.out.println();
                    break;
                case 3:
                    dollQueueManager.showWaitingList();
                    System.out.println();
                    break;
                case 4:
                    dollStackManager.showStack();
                    System.out.println();
                    break;
                case 5:
                    dollHistoryManager.showAllHistory();
                    System.out.println();
                    break;
                case 6:
                    dollHistoryManager.showAllUniqueHistory();
                    System.out.println();
                    break;
                case 0:
                    System.out.println("👋 프로그램을 종료합니다.");
                    System.exit(0);
            }
        }

    }
}
