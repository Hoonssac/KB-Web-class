package designpattern.Strategy.practice.p01;

public class TestFilter {
    public static void main(String[] args) {
        FilterStrategy f1 = new SmoothSkinFilter();
        System.out.println(f1.apply("My Face")); // "my face✨"

        FilterStrategy f2 = new CuteEyesFilter();
        System.out.println(f2.apply("Beautiful")); // "B👁👁t👁f👁l"

        FilterStrategy f3 = new KawaiiFilter();
        System.out.println(f3.apply("Lovely")); // "ylevoL🌸"
    }
}
