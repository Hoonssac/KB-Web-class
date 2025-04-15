package ch05.practice;

public class p04 {
    public static void main(String[] args) {
        // 4x + 5y = 60
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if ( 4 * i + 5 * j == 60) {
                    sb.append("(" + i + "," + j + ")\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
