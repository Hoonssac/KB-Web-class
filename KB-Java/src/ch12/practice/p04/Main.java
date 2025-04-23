package ch12.practice.p04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidNameException, InvalidGenderException {
        MaleCelebrity[] maleCelebs = {
                new MaleCelebrity("박서준"),
                new MaleCelebrity("차은우"),
                new MaleCelebrity("정해인")
        };

        FemaleCelebrity[] femaleCelebs = {
                new FemaleCelebrity("아이유"),
                new FemaleCelebrity("장원영")
        };

        MaleMatchGame maleGame = new MaleMatchGame(maleCelebs);
        FemaleMatchGame femaleGame = new FemaleMatchGame(femaleCelebs);

        Scanner sc = new Scanner(System.in);
        System.out.println("=== 이상형 월드컵 ===");
        System.out.println("1. 남자 연예인 월드컵");
        System.out.println("2. 여자 연예인 월드컵");
        System.out.print("경기를 선택하세요: ");

        try {
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println();
                    maleGame.printCandidates();
                    break;
                case 2:
                    System.out.println();
                    femaleGame.printCandidates();
                    break;
                default:
                    throw new InvalidGenderException(">> 잘못된 선택입니다! 1 또는 2만 입력하세요.");
            }

        } catch (InvalidGenderException e) {
            System.out.println(e.getMessage());
        }  catch (NumberFormatException e) {
            System.out.println(">> 숫자만 입력하세요! (1 또는 2)");
        }
    }
}
