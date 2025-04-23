package ch12.practice.p02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CelebrityRegister {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> male = new ArrayList<>();
        List<String> female = new ArrayList<>();

        System.out.print("남자 연예인 몇 명 등록할까요? ");
        int maleCount = Integer.parseInt(sc.nextLine());
        while (male.size() < maleCount) {
            System.out.print("이름 입력: ");
            String name = sc.nextLine();
            try {
                MaleCelebrity maleCelebrity = new MaleCelebrity(name);
                boolean jungbook = false;
                for (String compareName : male) {
                    if (!maleCelebrity.equals(compareName)) {
                        jungbook = true;
                        break;
                    }
                }

                if (!jungbook) {
                    male.add(name);
                }
            } catch (InvalidNameException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("여자 연예인 몇 명 등록할까요? ");
        int femaleCount = Integer.parseInt(sc.nextLine());
        while (female.size() < femaleCount) {
            System.out.print("이름 입력: ");
            String name = sc.nextLine();
            try {
                FemaleCelebrity femaleCelebrity = new FemaleCelebrity(name);
                boolean jungbook = false;
                for (String compareName : female) {
                    if (!femaleCelebrity.equals(compareName)) {
                        jungbook = true;
                        break;
                    }
                }

                if (!jungbook) {
                    female.add(name);
                }
            } catch (InvalidNameException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println();
        System.out.println("[남자 연예인 리스트]");;
        for (String name : male) {
            System.out.println(name);
        }
        System.out.println();

        System.out.println("[여자 연예인 리스트]");
        for (String name : female) {
            System.out.println(name);
        }
    }
}
