package ch07.practice.p04;

public class FusionRecipe extends Recipe {
    public FusionRecipe() {
        super("매콤달콤한", "불닭파스타", 5, false);
    }

    @Override
    public String getDescription() {
        return this.style + " " + this.title + "를 추천합니다!";
    }
}
