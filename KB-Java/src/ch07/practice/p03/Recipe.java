package ch07.practice.p03;

public class Recipe {
    protected String style;
    protected String title;
    protected int cookTime;
    protected boolean isVegan;

    public String getDescription() {
        return style + " " + title + "를 추천합니다!";
    }

    public String toString() {
        String vegan;
        if (isVegan) {
            vegan = "비건";
        } else {
            vegan = "비건 아님";
        }
        return title + "(" + cookTime + "분) - " + vegan;
    }

    public Recipe(String style, String title, int cookTime, boolean isVegan) {
        this.style = style;
        this.title = title;
        this.cookTime = cookTime;
        this.isVegan = isVegan;
    }
}


