package ch17.practice.p02.step2;

import ch17.practice.p02.data.GiftRepository;
import ch17.practice.p02.model.GiftItem;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryCountReport {
    public static void run() {
        List<GiftItem> list = GiftRepository.getGifts();

        System.out.println("📦 카테고리별 선물 개수 요약");
        list.stream()
                .collect(Collectors.groupingBy(GiftItem::getCategory, Collectors.counting()))
                .forEach((category, count) -> {
                    System.out.println(category + ": " + count + "개");
                });
    }
}
