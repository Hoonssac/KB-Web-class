package designpattern.Strategy.practice.p02;

public class CuteEyesFilter implements FilterStrategy {
    @Override
    public String apply(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char tmp = Character.toLowerCase(input.charAt(i));
            if (tmp=='a'||tmp=='e'||tmp=='i'||tmp=='o'||tmp=='u'){
                sb.append("👁");
            } else {
                sb.append(input.charAt(i));
            }
        }

        return sb.toString();
    }
}
