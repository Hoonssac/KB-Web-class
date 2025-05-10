package ch18.sec10;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class Product implements Serializable {
    private String name;
    private int price;

    @Override
    public String toString() {
        return name + ": " + price;
    }
}
