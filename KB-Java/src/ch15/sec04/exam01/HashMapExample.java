package ch15.sec04.exam01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        // Map 컬렉션 생성
        Map<String, Integer> map = new HashMap<>();

        // 객체 저장
        map.put("신용권", 85);
        map.put("홍길동", 90);
        map.put("동장군", 80);
        map.put("홍길동", 95);
        System.out.println("총 Entry 수: " + map.size());
        System.out.println();

        // 키로 값 얻기
        String key = "홍길동";

        // keySet : map의 키값들을 Set 형태로 가져오는 메소드
        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while (keyIterator.hasNext()) {
            String k = keyIterator.next();
            Integer v = map.get(k);
            System.out.println(k + " : " + v);
        }
        System.out.println();

        // 엔트리 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
        // entrySet : map의 entry들을 Set 형태로 가져오는 메소드
        Set<Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Entry<String, Integer> entry = entryIterator.next();
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + " : " + v);
        }
        System.out.println();

        // 키로 엔트리 삭제
        // remove : 키값으로 엔트리 삭제하는 메소드
        map.remove("홍길동");
        System.out.println("총 Entry 수: " + map.size());
        System.out.println();
    }
}
