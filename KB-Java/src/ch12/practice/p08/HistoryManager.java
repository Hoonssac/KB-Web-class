package ch12.practice.p08;

import java.text.SimpleDateFormat;
import java.util.*;

public class HistoryManager {
    private List<String> history = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void saveSelection(int round, Celebrity c1, Celebrity c2, Celebrity winner, boolean isFinal) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String roundInfo = isFinal ? "[결승]" : "[" + round + "라운드]";
        String record = roundInfo + " " + c1.getName() + " vs " + c2.getName() + " -> 선택: " + winner.getName() + " (" + timeStamp + ")";
        history.add(record);

    }

    public void showSelectionHistory() {
        if (history.isEmpty()) {
            System.out.println("\n=== [히스토리] ===");
            System.out.println("아직 기록된 선택 내역이 없습니다.");
            return;
        }

        System.out.println("\n📂 히스토리를 어떤 순서로 볼까요?");
        System.out.println("1. 최근 선택부터 (Stack: 후입선출)");
        System.out.println("2. 오래된 선택부터 (Queue: 선입선출");
        System.out.print("선택: ");

        int choice;
        try {
            choice = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("⚠️ 숫자를 입력하세요!");
            return;
        }

        System.out.println("\n=== [히스토리] ===");

        if (choice == 1) {
            Stack<String> stack = new Stack<>();
            stack.addAll(history);
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        } else if (choice == 2) {
            Queue<String> queue = new LinkedList<>(history);
            while (!queue.isEmpty()) {
                System.out.println(queue.poll());
            }
        } else {
            System.out.println("⚠️ 잘못된 선택입니다! (1 또는 2만 입력)");
        }
    }

    public void clearHistory() {
        history.clear();
    }


}
