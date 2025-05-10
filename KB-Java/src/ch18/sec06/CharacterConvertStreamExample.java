package ch18.sec06;

import java.io.*;

public class CharacterConvertStreamExample {
    public static void main(String[] args) throws Exception {
        write("문자 변환 스트림을 사용합니다.");
        String data = read();
        System.out.println(data);
    }

    // 문자열을 UTF-8로 인코딩하여 파일에 저장
    public static void write(String str) throws Exception {
        OutputStream os = new FileOutputStream("/Users/hoonssac/Desktop/KB-web-class/KB-Java/src/ch18/sec06/test.txt");
        // 바이트 -> 문자 스트림 변환
        Writer writer = new OutputStreamWriter(os, "UTF-8");
        writer.write(str);
        writer.flush();
        writer.close();
    }

    // 파일에서 UTF-8로 디코딩된 문자열 읽기
    public static String read() throws Exception {
        InputStream is = new FileInputStream("/Users/hoonssac/Desktop/KB-web-class/KB-Java/src/ch18/sec06/test.txt");
        // 바이트 -> 문자 스트림 변환
        Reader reader = new InputStreamReader(is, "UTF-8");
        char[] data = new char[100]; // 최대 100자 읽기
        int num = reader.read(data);
        reader.close();

        // 읽은 문자 수만큼 문자열 생성
        String str = new String(data, 0, num);
        return str;
    }
}
