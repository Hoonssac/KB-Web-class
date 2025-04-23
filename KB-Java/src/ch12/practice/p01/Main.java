package ch12.practice.p01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("참가자 이름을 입력하세요: ");
        String name = sc.nextLine();

        try {
            validateName(name);
            System.out.println("(다음 단계로 진행합니다!)");
        } catch (InivalidNameException e) {
            System.out.println("😡 탈락! 잘못된 이름입니다: " + e.getMessage());
        }
    }

    public static void validateName(String name) throws InivalidNameException {
        if (!name.matches("^[가-힣]{2,10}$")) {
            throw new InivalidNameException("이름은 한글 2~10자여야 합니다!");
        }
    }
}
