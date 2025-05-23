package ch15.sec03.exam01;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        // HastSet 컬렉션 생성
        Set<String> set = new HashSet<>();

        // 객체 지정
        set.add("Java");
        set.add("JDBC");
        set.add("Servlet/JSP");
        set.add("Java"); // 중복 객체이므로 저장하지 않음
        set.add("iBATIS");

        // 저장된 객체 수 출력
        int size = set.size();
        System.out.println("총 객체 수: " + size);
    }
}
