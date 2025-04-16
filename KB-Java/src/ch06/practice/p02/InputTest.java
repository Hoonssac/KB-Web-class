package ch06.practice.p02;

import static ch06.practice.p02.Input.sc;

public class InputTest {
    public static void main(String[] args) {
        System.out.print("이름: ");
        String name = Input.read(sc.nextLine());
        System.out.println();

        System.out.print("이름(홍길동):");
        String name2 = sc.nextLine();
        String name3 = Input.read("홍길동", name2);
        System.out.println();

        System.out.print("나이: ");
        String age = Input.read(sc.nextLine());
        System.out.println();

        System.out.print("종료할까요? (Y/n): ");
        String input = sc.nextLine();
        boolean tf = Input.confirm(input);

        System.out.print("종료할까요? (Y/n): ");
        String input2 = sc.nextLine();
        boolean tf2 = Input.confirm(input2);
    }
}
