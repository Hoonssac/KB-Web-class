package ch05.practice;

public class p01 {
    public static void main(String[] args) {
        // for 문을이용해서1부터100까지의정수중에서3의배수의총합을출력하는코드를작성하세요.
        int result = 0;

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                result += i;
            }
        }
        System.out.println(result);
    }
}
