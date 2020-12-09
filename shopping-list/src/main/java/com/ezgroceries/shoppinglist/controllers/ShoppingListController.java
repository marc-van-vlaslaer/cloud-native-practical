package com.ezgroceries.shoppinglist.controllers;

import com.ezgroceries.shoppinglist.resources.CocktailResource;
import com.ezgroceries.shoppinglist.resources.ShoppingListResource;
import com.ezgroceries.shoppinglist.services.CocktailService;
import com.ezgroceries.shoppinglist.services.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = {"/shopping-lists", "/api"}, produces = "application/json")
public class ShoppingListController {

    @Autowired
    private ShoppingListService shoppingListService;

    @Autowired
    private CocktailService cocktailService;

    @GetMapping
    public List<ShoppingListResource> getAllShoppingLists(){

        return shoppingListService.getAllShoppingLists();
    }

    @GetMapping("/{shoppingListId}")
    public Optional<ShoppingListResource> getShoppingList (@PathVariable UUID shoppingListId){
        return shoppingListService.getShoppingList(shoppingListId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingListResource addShoppingList(@RequestBody ShoppingListResource shoppingListResource) {
        return shoppingListService.addShoppingList(shoppingListResource);
    }

    @PutMapping(value = "/{shoppingListId}/cocktails",
            consumes = "application/json", produces = "application/json")
    public ShoppingListResource updateShoppingList(@RequestBody List<CocktailResource> cocktailResource,
                                           @PathVariable  String shoppingListId) {
        return shoppingListService.addCocktailsToShoppingList(shoppingListId, cocktailResource);

    }

//    @DeleteMapping("/shopping-lists/{shoppingListId}")
//    public void deleteShoppingList (@PathVariable UUID shoppingListId){
//        shoppingListService.deleteShoppingList(shoppingListId);
//    }

}



