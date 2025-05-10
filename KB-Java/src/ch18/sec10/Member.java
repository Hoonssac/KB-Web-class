package ch18.sec10;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class Member implements Serializable {
    private String id;
    private String name;

    @Override
    public String toString() {
        return id + ": " + name;
    }
}
