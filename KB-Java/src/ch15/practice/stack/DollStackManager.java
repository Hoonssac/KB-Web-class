package ch15.practice.stack;


import java.util.Random;
import java.util.Stack;

import static ch15.practice.Main.dollHistoryManager;


public class DollStackManager {
    Stack<String> stack = new Stack<>();
    String[] dolls = {
            "피카츄", "리자몽", "꼬부기", "쿠로미", "헬로키티",
            "뽀로로", "짱구", "도라에몽", "스폰지밥", "미니언"
    };
    Random random = new Random();

    public String storeRandomdoll() {
        int randomIndex = random.nextInt(dolls.length-1);
        stack.push(dolls[randomIndex]);
        System.out.println("🐻 " + dolls[randomIndex] + " 인형이 보관함에 추가되었습니다.");
        return dolls[randomIndex];
    }

    public void showStack() {
        System.out.print("🐻 현재 보관 중인 인형: ");
        System.out.println(stack);
    }
}
