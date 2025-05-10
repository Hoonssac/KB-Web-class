package ch18.practice.p02;

import java.io.*;

public class UserFileService {
    public static UserInfo loadUserInfo() throws Exception {
        System.out.println("[운명 정보 불러오는 중...]\n");
        BufferedReader reader = new BufferedReader(new FileReader("/Users/hoonssac/Desktop/KB-web-class/KB-Java/src/ch18/practice/p02/user_input.txt"));
        String name = null;
        String birth = null;

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();
                if (key.equals("이름")) {
                    name = value;
                } else if (key.equals("생년월일")) {
                    birth = value;
                }
            }
        }
        reader.close();

        if (name != null && birth != null) {
            return new UserInfo(name, birth);
        } else {
            throw new IllegalArgumentException("파일에 필요한 정보가 없습니다.");
        }
    }

}
