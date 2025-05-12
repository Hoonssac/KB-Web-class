package designpattern.Prototype.practice.p01.framework;

public interface Product extends Cloneable {
    void use(String content);
    Product createCopy();
}
