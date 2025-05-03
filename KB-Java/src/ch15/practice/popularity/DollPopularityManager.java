package ch15.practice.popularity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DollPopularityManager {
    private Map<String, Integer> countMap = new HashMap<>();

    public void addDoll(String dollName) {
        countMap.put(dollName, countMap.getOrDefault(dollName, 0) + 1);

    }

    public void showRanking() {
        if (!countMap.isEmpty()) {
            ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(countMap.entrySet());
            list.sort((entry1, entry2) -> {
                int compareValue = entry2.getValue().compareTo(entry1.getValue()); // Integer 내림차순
                if (compareValue == 0) {
                    return entry1.getKey().compareTo(entry2.getKey()); // String 오름차순
                }
                return compareValue;
            });

            System.out.println("🔥 인형별 인기 순위 (많이 뽑힌 순)");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i).getKey() + " - " + list.get(i).getValue() + "회");
            }
        }
        else {
            System.out.println("📊 아직 뽑힌 인형이 없습니다.");
        }
        System.out.println();
    }
}
