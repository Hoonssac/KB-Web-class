package ch17.sec01;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("김고은");
        set.add("서상훈");
        set.add("감자바");

        // Stream 이용해서 요소를 하나씩 출력
        Stream<String> stream = set.stream();
        stream.forEach(name -> System.out.println(name));
    }
}
