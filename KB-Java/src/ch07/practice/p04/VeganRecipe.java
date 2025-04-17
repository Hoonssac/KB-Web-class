package ch07.practice.p04;

public class VeganRecipe extends Recipe {
    public VeganRecipe() {
        super("신선한", "두부 샐러드", 10, true);
    }

    @Override
    public String getDescription() {
        return this.style + " " + this.title + "를 추천합니다!";
    }
}
