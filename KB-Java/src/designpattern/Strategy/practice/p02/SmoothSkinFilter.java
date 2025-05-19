package designpattern.Strategy.practice.p02;

public class SmoothSkinFilter implements FilterStrategy {
    @Override
    public String apply(String input) {
        return input.toLowerCase() + "✨";
    }
}
