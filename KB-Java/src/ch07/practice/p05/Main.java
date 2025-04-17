package ch07.practice.p05;

public class Main {
    public static void main(String[] args) {
        Recipe[] recipes = {new KoreanRecipe(), new VeganRecipe(), new FusionRecipe()};

        for (int i = 0; i < recipes.length; i++) {
            System.out.println(recipes[i].getDescription());
            if (recipes[i] instanceof KoreanRecipe) {
                KoreanRecipe koreanRecipe = (KoreanRecipe) recipes[i];
                System.out.println("→ " + koreanRecipe.getSpicinessLevel());
                System.out.println();
            }
            System.out.println();
        }
    }
}
