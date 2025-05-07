package ch16.practice.p03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class Main {
    static List<Goods> giftPool = Arrays.asList(
            new Goods("메타몽 쿠션", "분홍", false),
            new Goods("메타몽 키링", "파랑", false),
            new Goods("메타몽 텀블러", "보라", true),
            new Goods("메타몽 노트북 파우치", "회색", true),
            new Goods("메타몽 인형", "분홍", false),
            new Goods("메타몽 가방", "회색", true)
    );

    public static void main(String[] args) {
        Predicate<Goods> pinkFilter = g -> g.getColor().equals("분홍");
        printResult("이슬이", pickGifts(giftPool), pinkFilter, "성공! 분홍색 굿즈를 얻었어요! 🎉", "실패! 분홍색 굿즈가 없어요 🥲");

        Predicate<Goods> usefulFilter = g -> g.isUseful();
        printResult("지우", pickGifts(giftPool), usefulFilter, "성공! 유용한 굿즈를 얻었어요! 👍", "실패! 유용한 굿즈가 없어요 🥲");
    }

    public static List<Goods> pickGifts(List<Goods> pool) {
        Random random = new Random();
        List<Goods> selectedGifts = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            int index = random.nextInt(pool.size());
            selectedGifts.add(pool.get(index));
        }
        return selectedGifts;
    }

    public static void printResult(String user, List<Goods> picks, Predicate<Goods> condition, String successMsg, String failMsg) {
        System.out.println("[" + user + "의 뽑기 결과]");
        for (Goods good : picks) {
            System.out.println("- " + good.getName() + " (" + good.getColor() + ")");
        }

        if (picks.stream().anyMatch(good -> condition.test(good))) {
            System.out.println("→ " + successMsg);
        } else {
            System.out.println("→ " + failMsg);
        }
        System.out.println();
    }
}
