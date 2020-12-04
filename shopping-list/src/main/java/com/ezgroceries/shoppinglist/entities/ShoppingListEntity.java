package com.ezgroceries.shoppinglist.entities;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "shopping_list")
public class ShoppingListEntity {

    @Id
    @Column(name = "id")
    private UUID shoppingListId;

    @Column(name = "name")
    private String name;

    public ShoppingListEntity() {
    }

    public ShoppingListEntity(UUID id, String name) {
        this.shoppingListId = id;
        this.name = name;
    }

    @ManyToMany
    @JoinTable(
            name = "COCKTAIL_SHOPPING_LIST",
            joinColumns = {@JoinColumn(name = "shopping_list_id")},
            inverseJoinColumns = {@JoinColumn(name = "cocktail_id")})
    private List<CocktailEntity> cocktailEntities;

    public UUID getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(UUID shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CocktailEntity> getCocktailEntities() {
        return cocktailEntities;
    }

    public void setCocktailEntities(List<CocktailEntity> cocktailEntities) {
        this.cocktailEntities = cocktailEntities;
    }
}
