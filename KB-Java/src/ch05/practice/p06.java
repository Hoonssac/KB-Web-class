package ch05.practice;

public class p06 {
    public static void main(String[] args) {
        int[][] array = {{95, 86}, {83, 92, 96}, {78, 83, 93, 87, 88}};
        int total = 0;
        int count = 0;

        for (int[] tmp : array) {
            for (int i = 0; i < tmp.length; i++) {
                total += tmp[i];
                count++;
            }
        }
        System.out.println("총합 : " + total);
        System.out.printf("평균 : %.1f%n" , (double) total / count);
    }
}
