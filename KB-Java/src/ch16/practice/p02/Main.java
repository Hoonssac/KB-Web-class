package ch16.practice.p02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main{
    public static List<Goods> goods = new ArrayList<>();

    public static void main(String[] args) {
        goods.add(new Goods("메타몽 쿠션", "분홍", false));
        goods.add(new Goods("메타몽 노트북 파우치", "보라", true));
        goods.add(new Goods("메타몽 인형", "분홍", false));
        goods.add(new Goods("메타몽 가방", "회색", true));
        goods.add(new Goods("메타몽 키링", "파랑", false));

        Predicate<Goods> pinkFilter = g -> g.getColor().equals("분홍");
        printSelectedGoods("이슬이", pinkFilter);

        Predicate<Goods> usefulFilter = g -> g.isUseful();
        printSelectedGoods("지우", usefulFilter);

    }

    public static void printSelectedGoods(String user, Predicate<Goods> filter) {
        // 조건에 맞는 굿즈만 골라 출력
        System.out.println("[" + user + "의 선택]");
        goods.stream()
                .filter(filter)
                .forEach(g -> System.out.println("- " + g.getName()));
        System.out.println();
    }
}
