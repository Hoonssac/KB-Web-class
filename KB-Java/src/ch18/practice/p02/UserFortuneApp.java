package ch18.practice.p02;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class UserFortuneApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("[사주 운세 뽑기 머신]");
        System.out.print("이름을 입력하세요: ");
        String name = sc.next();
        System.out.print("생년월일을 입력하세요 (예: 1994-07-21): ");
        String birth = sc.next();

        try (Writer writer = new FileWriter("/Users/hoonssac/Desktop/KB-web-class/KB-Java/src/ch18/practice/p02/user_input.txt")) {
            writer.write("이름: " + name + "\n");
            writer.write("생년월일: " + birth);
            System.out.println("✅ 운명 파일(user_input.txt)에 정보가 기록되었습니다.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserInfo loadedUser = UserFileService.loadUserInfo();
        System.out.println("\n[입력 정보 확인]");
        System.out.println(loadedUser);
        ;
    }
}
