package ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("/Users/hoonssac/Desktop/KB-web-class/KB-Java/src/ch18/sec03/exam02/test2.db")) {
            // 최대 100바이트 담을 수 있는 배열 생성
            byte[] data = new byte[100];

            while (true) {
                // data 배열의 바이트 데이터 읽고, 읽은 바이트 수 반환
                int num = is.read(data); // 최대 100바이트 읽기
                // 파일 끝에 도달했으면 종료
                if (num == -1) {
                    break;
                }
                for (int i = 0; i < num; i++) {
                    System.out.println(data[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
