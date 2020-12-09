package com.ezgroceries.shoppinglist.resources;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ShoppingListResource {
    private UUID shoppingListId;
    private String name;
    private List<String> cocktailId;
    private Set<String> ingredients;

    public ShoppingListResource(){

    }

    public ShoppingListResource (UUID shoppingListId, String name, List<String> cocktailId, Set<String> ingredients) {
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

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(List<String> cocktailId) {
        this.cocktailId = cocktailId;
    }

}
