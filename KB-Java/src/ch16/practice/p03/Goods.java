package ch16.practice.p03;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Goods {
    private String name;
    private String color;
    private boolean useful;

    @Override
    public String toString() {
        return "Goods{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
