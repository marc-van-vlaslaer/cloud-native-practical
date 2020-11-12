package com.ezgroceries.shoppinglist.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingList {
    private UUID shoppingListId;
    private String name;
    private List<String> ingredients = new ArrayList<>();

    public ShoppingList(){

    }

    public ShoppingList (UUID shoppingListId, String name, List<String> ingredients) {
        super();
        this.shoppingListId = shoppingListId;
        this.name = name;
        this.ingredients = ingredients;

    }

    public ShoppingList (String name) {
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

    public void addIngredient(ShoppingList shoppingList,String ingredient) {
         if (shoppingList.ingredients.contains(ingredient)) {
         } else {
             shoppingList.ingredients.add(ingredient);
         }


    }

}
