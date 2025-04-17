package ch07.practice.p04;

public class Recipe {
    protected String style;
    protected String title;
    protected int cookTime;
    protected boolean isVegan;

    public String getDescription() {
        return null;
    }

    public Recipe(String style, String title, int cookTime, boolean isVegan) {
        this.style = style;
        this.title = title;
        this.cookTime = cookTime;
        this.isVegan = isVegan;
    }
}


