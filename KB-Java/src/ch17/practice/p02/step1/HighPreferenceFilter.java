package ch17.practice.p02.step1;

import ch17.practice.p02.data.GiftRepository;
import ch17.practice.p02.model.GiftItem;

import java.util.List;

public class HighPreferenceFilter {
    public static void run() {
        List<GiftItem> list = GiftRepository.getGifts();

        System.out.println("🎁 부모님이 진짜 좋아하시는 선물 리스트");
        list.stream()
                .filter((g -> g.getPreferenceScore() >= 70))
                .forEach(g -> System.out.println(g.getName()));
    }
}
