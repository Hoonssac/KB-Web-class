package ch09.adapter1;

public class Main {
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printString();
    }

    public static void print(Print p) {
        p.printWeak();
        p.printString();
    }
}
