package ch13.practice.p03;

public class QuizLinkedList {

    QuizNode head = new QuizNode();

    void addLast(String title, String content) {
        // 새로운 문제를 리스트의 마지막에 추가하는 메서드
        QuizNode newNode = new QuizNode();
        newNode.title = title;
        newNode.content = content;

        QuizNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    void printAll() {
        // 리스트에 저장된 모든 문제를 문제 제목과 문제 내용을 순서대로 출력하는 메서드
        //=== 현재 도전할 문제 리스트 ===
        //문제 제목: 초인종이 없을 때를 두 글자로 줄이면?
        //문제 내용: 노벨
        //
        //문제 제목: 보라돌이 나나 뽀가 자기들끼리 식사할 때 두비가 하는 말은?
        //문제 내용: 뚜비두밥
        //
        //문제 제목: 등산을 좋아하는 왕은?
        //문제 내용: 하이킹
        //
        //문제 제목: 고등학생이 싫어하는 나무는?
        //문제 내용: 야자나무
        System.out.println("=== 현재 도전할 문제 리스트 ===");
        QuizNode start = head.next;
        while (start != null) {
            System.out.println("문제 제목: " + start.title);
            System.out.println("문제 내용: " + start.content + "\n");
            start = start.next;
        }
    }
}
