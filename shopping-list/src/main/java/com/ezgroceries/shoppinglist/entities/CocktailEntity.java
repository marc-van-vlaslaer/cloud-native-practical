package com.ezgroceries.shoppinglist.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "cocktail")
public class CocktailEntity {

    @Id
    @Column(name = "id")
    private UUID cocktailId;

    @Column(name = "id_drink")
    private String idDrink;

    @Column(name = "name")
    private String name;

    @Column(name = "ingredients")
    @Convert(converter = StringSetConverter.class)
    private Set<String> ingredients;

    @ManyToMany
    @JoinTable(
            name = "COCKTAIL_SHOPPING_LIST",
            joinColumns = {@JoinColumn(name = "cocktail_id")},
            inverseJoinColumns = {@JoinColumn(name = "shopping_list_id")}
    )
    private List<ShoppingListEntity> shoppingListEntities;

    public CocktailEntity() {
    }

    public CocktailEntity(UUID cocktailId, String idDrink, String name, Set<String> ingredients) {
        this.cocktailId = cocktailId;
        this.idDrink = idDrink;
        this.name = name;
        this.ingredients = ingredients;
    }

    public UUID getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(UUID cocktailId) {
        this.cocktailId = cocktailId;
    }

    public String getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(String idDrink) {
        this.idDrink = idDrink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<ShoppingListEntity> getShoppingListEntities() {
        return shoppingListEntities;
    }

    public void setShoppingListEntities(List<ShoppingListEntity> shoppingListEntities) {
        this.shoppingListEntities = shoppingListEntities;
    }
}
