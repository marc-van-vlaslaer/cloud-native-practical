package com.ezgroceries.shoppinglist.services;

import com.ezgroceries.shoppinglist.clients.CocktailDBClient;
import com.ezgroceries.shoppinglist.model.CocktailDBResponse;
import com.ezgroceries.shoppinglist.resources.CocktailResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CocktailService {

    private final CocktailDBClient cocktailDBClient;

    public CocktailService(CocktailDBClient cocktailDBClient) {
        this.cocktailDBClient = cocktailDBClient;
    }

    public List<CocktailResource> searchCocktail(String search) {
        System.out.println("search cocktail 1");
        CocktailDBResponse cocktailDBResponse = cocktailDBClient.searchCocktails(search);
        System.out.println("search cocktail 2");
        List<CocktailResource> cocktails = new ArrayList<>();
        System.out.println("search cocktail 3");
        List<CocktailDBResponse.DrinkResource> drinkResourceList = cocktailDBResponse.getDrinks();
        System.out.println("search cocktail 4");
        for (CocktailDBResponse.DrinkResource drinkResource : drinkResourceList){
            System.out.println("for loop");
            CocktailResource cocktailResource = new CocktailResource();
            cocktailResource.setCocktailId(drinkResource.getIdDrink());
            cocktailResource.setCocktailId(drinkResource.getIdDrink());
            cocktailResource.setName(drinkResource.getStrDrink());
            cocktailResource.setGlass(drinkResource.getStrGlass());
            cocktailResource.setInstructions(drinkResource.getStrInstructions());
            cocktailResource.setImage(drinkResource.getStrDrinkThumb());
            cocktailResource.setIngredients(this.getIngredients(drinkResource));
            cocktails.add(cocktailResource);
        }

        return cocktails;
    }

    public List<CocktailResource> getCocktail(String search) {
        System.out.println("get cocktail 1");
        CocktailDBResponse cocktailDBResponse = cocktailDBClient.searchCocktails(search);
        System.out.println("get cocktail 2");
        List<CocktailResource> cocktail = new ArrayList<>();
        System.out.println("get cocktail 3");
        List<CocktailDBResponse.DrinkResource> drinkResourceList = cocktailDBResponse.getDrinks();
        System.out.println("get cocktail 4");
        for (CocktailDBResponse.DrinkResource drinkResource : drinkResourceList){
            System.out.println("for loop get");
            CocktailResource cocktailResource = new CocktailResource();
            cocktailResource.setCocktailId(drinkResource.getIdDrink());
            cocktailResource.setCocktailId(drinkResource.getIdDrink());
            cocktailResource.setName(drinkResource.getStrDrink());
            cocktailResource.setGlass(drinkResource.getStrGlass());
            cocktailResource.setInstructions(drinkResource.getStrInstructions());
            cocktailResource.setImage(drinkResource.getStrDrinkThumb());
            cocktailResource.setIngredients(this.getIngredients(drinkResource));
            cocktail.add(cocktailResource);
        }

        return cocktail;
    }

        private List<String> getIngredients(CocktailDBResponse.DrinkResource drinkResource){
            List<String> ingredients = new ArrayList<>();
            if (drinkResource.getStrIngredient1() != null)
                ingredients.add(drinkResource.getStrIngredient1());
            if (drinkResource.getStrIngredient2() != null)
                ingredients.add(drinkResource.getStrIngredient2());
            if (drinkResource.getStrIngredient3() != null)
                ingredients.add(drinkResource.getStrIngredient3());
            if (drinkResource.getStrIngredient4() != null)
                ingredients.add(drinkResource.getStrIngredient4());
            if (drinkResource.getStrIngredient5() != null)
                ingredients.add(drinkResource.getStrIngredient5());
            if (drinkResource.getStrIngredient6() != null)
                ingredients.add(drinkResource.getStrIngredient6());
            if (drinkResource.getStrIngredient7() != null)
                ingredients.add(drinkResource.getStrIngredient7());
            if (drinkResource.getStrIngredient8() != null)
                ingredients.add(drinkResource.getStrIngredient8());
            if (drinkResource.getStrIngredient9() != null)
                ingredients.add(drinkResource.getStrIngredient9());
            if (drinkResource.getStrIngredient10() != null)
                ingredients.add(drinkResource.getStrIngredient10());
            if (drinkResource.getStrIngredient11() != null)
                ingredients.add(drinkResource.getStrIngredient11());
            if (drinkResource.getStrIngredient12() != null)
                ingredients.add(drinkResource.getStrIngredient12());
            if (drinkResource.getStrIngredient13() != null)
                ingredients.add(drinkResource.getStrIngredient13());
            if (drinkResource.getStrIngredient14() != null)
                ingredients.add(drinkResource.getStrIngredient14());
            if (drinkResource.getStrIngredient15() != null)
                ingredients.add(drinkResource.getStrIngredient15());


            return ingredients;

        }





}
