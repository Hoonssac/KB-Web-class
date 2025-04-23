package ch12.practice.p05;

import java.util.Objects;

public class MaleCelebrity implements Celebrity {
    private String name;

    public MaleCelebrity(String name) throws InvalidNameException {
        validateName(name);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void validateName(String name) throws InvalidNameException {
        if (!name.matches("^[가-힣]{2,10}$")) {
            throw new InvalidNameException("이름은 한글 2~10자여야 합니다!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this.getName().equals(o.toString())) {
            System.out.println(">> 중복된 이름입니다. 등록하지 않습니다.");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
