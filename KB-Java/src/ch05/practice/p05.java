package ch05.practice;

public class p05 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 8, 2};
        int max = 0;

        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        System.out.println(max);
    }
}
