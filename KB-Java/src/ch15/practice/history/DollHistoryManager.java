package ch15.practice.history;

import java.util.*;

public class DollHistoryManager {
    Map<String, List<String>> historyMap = new HashMap<>();

    public void addHistory(String customer, String doll) {
        historyMap.computeIfAbsent(customer, k -> new ArrayList<>()).add(doll);
        System.out.println("📒 " + customer + " 님의 인형 기록에 '" + doll + "'이 추가되었습니다.");
    }

    public void showAllHistory() {
        if (!historyMap.isEmpty()) {
            System.out.println("📋 고객별 인형 기록:");
            for (String key : historyMap.keySet()) {
                System.out.print("- " + key + ": ");
                System.out.println(historyMap.get(key));
            }
        } else {
            System.out.println("📋 아직 기록된 고객이 없습니다.");
        }
    }

    public void showAllUniqueHistory() {
        if (!historyMap.isEmpty()) {
            for (String key : historyMap.keySet()) {
                Set<String> unique = new HashSet<>(historyMap.get(key));
                Iterator<String> it = unique.iterator();

                System.out.println("🎁 중복 인형 제거 이벤트 결과:");
                System.out.print("- " + key + ": [");
                while (it.hasNext()) {
                    System.out.print(it.next() + ", ");
                }
                System.out.println("\b\b]");
            }
        } else {
            System.out.println("📋 아직 기록된 고객이 없습니다.");
        }
    }
}
