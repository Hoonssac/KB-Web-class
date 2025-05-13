package designpattern.builder.builder1;

// 문서를 구성하기 위한 메소드를 규정한 추상 클래스
public abstract class Builder {
    public abstract void makeTitle(String title);

    public abstract void makeString(String str);

    public abstract void makeItems(String[] items);

    public abstract void close();
}
