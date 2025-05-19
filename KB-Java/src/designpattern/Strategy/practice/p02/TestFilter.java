package designpattern.Strategy.practice.p02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, FilterStrategy> filter = new HashMap<>();
        filter.put("smooth", new SmoothSkinFilter());
        filter.put("cute", new CuteEyesFilter());
        filter.put("kawaii", new KawaiiFilter());

        System.out.println("📸 AI 필터 엔진에 오신 걸 환영합니다!");
        System.out.println("✨ 사용할 필터를 선택해주세요 (smooth, cute, kawaii, exit)\n");

        while (true) {
            System.out.print(">> 적용할 필터 입력: ");
            String input = sc.nextLine().toLowerCase();
            if (input.equals("exit")) {
                System.out.println("📸 필터 부스를 종료합니다. 안녕히 가세요!");
                System.exit(0);
            }

            FilterStrategy filterStrategy = filter.get(input);
            if (filterStrategy == null) {
                System.out.println("⚠️ 존재하지 않는 필터입니다. 다시 입력해주세요.\n");
            } else {
                System.out.print(">> 사진 입력: ");
                String photo = sc.nextLine();
                System.out.print("[사용 필터: " + input + "] => ");
                System.out.println(filterStrategy.apply(photo) + "\n");
            }
        }
    }
}
