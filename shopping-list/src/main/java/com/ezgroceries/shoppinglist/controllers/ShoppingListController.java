package com.ezgroceries.shoppinglist.controllers;

import com.ezgroceries.shoppinglist.model.ShoppingList;
import com.ezgroceries.shoppinglist.resources.CocktailResource;
import com.ezgroceries.shoppinglist.services.CocktailService;
import com.ezgroceries.shoppinglist.services.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = {"/shopping-lists", "/api"}, produces = "application/json")
public class ShoppingListController {

    @Autowired
    private ShoppingListService shoppingListService;

    @Autowired
    private CocktailService cocktailService;

    @GetMapping
    public List<ShoppingList> getAllShoppingLists(){
        return ShoppingListService.getAllShoppingLists();
    }

    @GetMapping("/{shoppingListId}")
    public ShoppingList getShoppingList (@PathVariable UUID shoppingListId){
        return shoppingListService.getShoppingList(shoppingListId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingList addShoppingList(@RequestBody ShoppingList shoppingList) {
        return shoppingListService.addShoppingList(shoppingList);
    }

    @PutMapping(value = "/{shoppingListId}/cocktails",
            consumes = "application/json", produces = "application/json")
    public void updateShoppingList(@RequestBody List<CocktailResource> cocktailResource,
                                   @PathVariable  UUID shoppingListId) {
        for(int i = 0; i < cocktailResource.size(); i++) {
//            CocktailResource refCocktail = cocktailService.getCocktail(cocktailResource.get(i).getCocktailId());
            CocktailResource refCocktail = (CocktailResource) cocktailService.getCocktail(cocktailResource.get(i).getCocktailId());
            shoppingListService.addIngredients(shoppingListId, refCocktail.getIngredients());
        }

    }

    @DeleteMapping("/shopping-lists/{shoppingListId}")
    public void deleteShoppingList (@PathVariable UUID shoppingListId){
        shoppingListService.deleteShoppingList(shoppingListId);
    }

}



