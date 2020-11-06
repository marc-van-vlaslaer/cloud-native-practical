package com.ezgroceries.shoppinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Configuration
@RestController
//@RequestMapping(value = "/shopping-lists", produces = "application/json")
public class ShoppingListController {

    @Autowired
    private ShoppingListService shoppingListService;

    @Autowired
    private CocktailService cocktailService;

    @RequestMapping("/shopping-lists")
    public List<ShoppingList> getAllShoppingLists(){
        return ShoppingListService.getAllShoppingLists();
    }

    @RequestMapping("/shopping-lists/{shoppingListId}")
    public ShoppingList getShoppingList (@PathVariable UUID shoppingListId){
        return shoppingListService.getShoppingList(shoppingListId);
    }

    @PostMapping(value = "/shopping-lists", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addShoppingList(@RequestBody ShoppingList shoppingList) {
        shoppingListService.addShoppingList(shoppingList);
    }

//    @PutMapping(value = "/shopping-lists/{shoppingListId}/cocktails",
//                consumes = "application/json", produces = "application/json")
//    public void updateShoppingList(@RequestBody ShoppingList shoppingList, @PathVariable UUID shoppingListId) {
//        shoppingListService.updateShoppingList(shoppingListId, shoppingList);
//    }

//    @PutMapping(value = "/shopping-lists/{shoppingListId}/cocktails",
//            consumes = "application/json", produces = "application/json")
//    public void updateShoppingList(@RequestBody CocktailResource cocktailResource, @PathVariable UUID shoppingListId) {
//        CocktailResource refCocktail = cocktailService.getCocktail(cocktailResource.getCocktailId());
//        System.out.println("refCocktail ingredients" + refCocktail.getIngredients());
//        shoppingListService.addIngredients(shoppingListId,refCocktail.getIngredients());
//
//    }

    @PutMapping(value = "/shopping-lists/{shoppingListId}/cocktails",
            consumes = "application/json", produces = "application/json")
    public void updateShoppingList(@RequestBody List<CocktailResource> cocktailResource,
                                   @PathVariable UUID shoppingListId) {
        for(int i = 0; i < cocktailResource.size(); i++) {
            CocktailResource refCocktail = cocktailService.getCocktail(cocktailResource.get(i).getCocktailId());
            System.out.println("refCocktail ingredients" + refCocktail.getIngredients());
            shoppingListService.addIngredients(shoppingListId, refCocktail.getIngredients());
        }

    }

    @DeleteMapping("/shopping-lists/{shoppingListId}")
    public void deleteShoppingList (@PathVariable UUID shoppingListId){
        shoppingListService.deleteShoppingList(shoppingListId);
    }

}



