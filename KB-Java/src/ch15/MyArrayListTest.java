package ch15;

public class MyArrayListTest {
    public static void main(String[] args) {
        // Integer 타입 테스트
        MyArrayList<Integer> intList = new MyArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        System.out.println("Integer List:");
        printList(intList);
        // String 타입 테스트
        MyArrayList<String> strList = new MyArrayList<>();
        strList.add("Apple");
        strList.add("Banana");
        strList.add("Cherry");
        System.out.println("String List:");
        printList(strList);
        // 중간 삽입, 삭제 테스트
        intList.add(1, 15); // 10, 15, 20, 30
        System.out.println("After inserting 15 at index 1:");
        printList(intList);
        int removed = intList.remove(2); // 20 제거
        System.out.println("Removed element: " + removed);
        printList(intList);
    }
    private static <T> void printList(MyArrayList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}