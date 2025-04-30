package ch13.practice.p02;

import java.util.Arrays;

public class QuizBox <T extends Quiz> {
    T[] list;
    int size;

    public QuizBox() {
        this.list = (T[]) new Quiz[5];
        size = 0;
    }

    public void add(T content) {
        if (size < list.length) {
            list[size++] = content;
        } else {
            list = Arrays.copyOf(list, size * 2);
            list[size++] = content;
        }
    }
    public void printAll() {
        int index = 1;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                System.out.println(index + ". " + list[i].getQuestion());
                index++;
            }
        }
    }


    public boolean remove(Content content) {
        for (int i = 0; i < list.length; i++) {
            if (content.getQuestion().equals(list[i].getQuestion())) {
                list[i] = null;
                return true;
            }
        }
        return false;
    }
    static <T extends Content> void removeFromBox(QuizBox<? super T> box, T quiz) {
        for (int i = 0; i < box.size; i++) {
            if (box.list[i].getQuestion().equals(quiz.getQuestion())) {
                box.list[i] = null;
                System.out.println("\n삭제 성공: " + quiz.getQuestion());
            }
        }
    }
}
