package com.ezgroceries.shoppinglist.resources;

import java.util.Set;
import java.util.UUID;

public class CocktailResource {
    private UUID cocktailId;
    private String name;
    private String glass;
    private String instructions;
    private String image;
    private Set<String> ingredients;

    public CocktailResource() {
    }

    public CocktailResource(UUID cocktailId, String name, String glass, String instructions, String image, Set<String> ingredients){
        this.cocktailId = cocktailId;
        this.name = name;
        this.glass = glass;
        this.instructions = instructions;
        this.image = image;
        this.ingredients = ingredients;
    }

    public void setCocktailId(UUID cocktailId) {
        this.cocktailId = cocktailId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }

    public UUID getCocktailId() {
        return cocktailId;
    }

    public String getName() {
        return name;
    }

    public String getGlass() {
        return glass;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getImage() {
        return image;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }
}
