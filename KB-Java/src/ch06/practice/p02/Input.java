package ch06.practice.p02;

import java.util.Scanner;

public class Input {
    static Scanner sc = new Scanner(System.in);

    static String read(String title) {
        System.out.print("입력값: " + title);
        return title;
    }

    static String read(String defaultValue, String title) {
        System.out.print("입력값: " + defaultValue);
        if (title.equals("")) {
            return defaultValue;
        } else {
            return title;
        }
    }

    static int readInt(String title) {
        System.out.print(title);
        return Integer.parseInt(title);
    }

    static boolean confirm(String title, boolean defaultValue) {
        boolean output = false;
        if (title.equals("Y")) {
            output = true;
        } else if (title.equals("")) {
            output = defaultValue;
        }
        System.out.println("입력값: " + output);
        return output;
    }

    static boolean confirm(String title) {
        return confirm(title, true);
    }
}
