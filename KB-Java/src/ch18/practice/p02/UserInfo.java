package ch18.practice.p02;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfo {
    private String name;
    private String birth;

    @Override
    public String toString() {
        return "이름: " + name + "\n생년월일: " + birth;
    }
}

