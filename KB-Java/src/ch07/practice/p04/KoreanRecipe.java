package ch07.practice.p04;

public class KoreanRecipe extends Recipe {

    public KoreanRecipe() {
        super("매콤한", "김치찌개", 20, false);
    }

    @Override
    public String getDescription() {
        return this.style + " " + this.title + "를 추천합니다!";
    }
}
