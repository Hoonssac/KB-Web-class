package ch13.sec02.exam01;

public class Product<K, M> { // 타입 파라미터로 K와 M 정의
    // 타입 파라미터를 필드 타입으로 사용
    private K kind;
    private M mode;

    public K getKind() {
        return kind;
    }

    public void setKind(K kind) {
        this.kind = kind;
    }

    public M getMode() {
        return mode;
    }

    public void setMode(M mode) {
        this.mode = mode;
    }
}
