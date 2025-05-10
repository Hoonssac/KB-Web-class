package ch18.sec07.exam02;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadLineExample {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/ch18/sec07/exam02/ReadLineExample.java"));

        int lineNo = 1; // 줄 번호
        while (true) {
            String str = br.readLine(); // 한 줄 읽기
            if (str == null) {
                break; // 파일 끝이라면 종료
            }
            System.out.println(lineNo + "\t" + str); // 줄 번호화 내용 출력
            lineNo++;
        }

        br.close();
    }
}
