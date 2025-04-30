package ch13.practice.p01;

import java.util.Arrays;

public class QuizBox<T extends Quiz> {
    T[] list;
    int size;

    public QuizBox() {
        this.list = (T[]) new Quiz[5];
        size = 0;
    }

    public void addQuiz(T quiz) {
        if (size < list.length) {
            list[size++] = quiz;
        } else {
            list = Arrays.copyOf(list, size + 1);
            list[size++] = quiz;
        }
    }

    public void printAll() {
        System.out.println("=== 퀴즈 박스 문제 목록 ===");
        for (int i = 0; i < list.length; i++) {
            System.out.println(i + ". " + list[i].getQuestion());
        }
    }
}
