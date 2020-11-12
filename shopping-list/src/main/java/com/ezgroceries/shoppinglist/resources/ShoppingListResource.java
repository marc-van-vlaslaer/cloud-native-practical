package com.ezgroceries.shoppinglist.resources;

import java.util.List;
import java.util.UUID;

public class ShoppingListResource {
    private UUID shoppingListId;
    private String name;
    private List<String> cocktailId;
    private List<String> ingredients;

    public ShoppingListResource (UUID shoppingListId, String name, List<String> cocktailId, List<String> ingredients) {
        this.shoppingListId = shoppingListId;
        this.name = name;
        this.cocktailId = cocktailId;
        this.ingredients = ingredients;

    }

    public ShoppingListResource (String name) {
        this.name = name;
        this.shoppingListId = UUID.randomUUID();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(UUID shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(List<String> cocktailId) {
        this.cocktailId = cocktailId;
    }

}
