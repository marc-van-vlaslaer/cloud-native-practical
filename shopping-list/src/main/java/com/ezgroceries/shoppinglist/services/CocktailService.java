package com.ezgroceries.shoppinglist.services;

import com.ezgroceries.shoppinglist.clients.CocktailDBClient;
import com.ezgroceries.shoppinglist.entities.CocktailEntity;
import com.ezgroceries.shoppinglist.model.CocktailDBResponse;
import com.ezgroceries.shoppinglist.repositories.CocktailRepository;
import com.ezgroceries.shoppinglist.resources.CocktailResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CocktailService {

    private final CocktailDBClient cocktailDBClient;
    @Autowired
    private CocktailRepository cocktailRepository;

    public CocktailService(CocktailDBClient cocktailDBClient, CocktailRepository cocktailRepository) {

        this.cocktailDBClient = cocktailDBClient;
        this.cocktailRepository = cocktailRepository;
    }


    public List<CocktailResource> searchCocktail(String search) {
        CocktailDBResponse cocktailDBResponse = cocktailDBClient.searchCocktails(search);
        List<CocktailResource> cocktails = new ArrayList<>();
        List<CocktailDBResponse.DrinkResource> drinkResourceList = cocktailDBResponse.getDrinks();
        for (CocktailDBResponse.DrinkResource drinkResource : drinkResourceList){
            System.out.println("cocktail found : " + drinkResource);
            //check if retrieved drinkId is already on database
            CocktailEntity cocktailEntity = cocktailRepository.findByIdDrink(drinkResource.getIdDrink());
            //insert on database if not present
            System.out.println("cocktailentity = " + cocktailEntity);
            if(cocktailEntity == null){
                System.out.println("cocktail not on database");
                CocktailEntity newCocktailEntity = new CocktailEntity();
                newCocktailEntity.setCocktailId(UUID.randomUUID());
                newCocktailEntity.setIdDrink(drinkResource.getIdDrink());
                newCocktailEntity.setName(drinkResource.getStrDrink());
                //newCocktailEntity.setIngredients(this.getIngredients(drinkResource));
                newCocktailEntity.setIngredients(drinkResource.getStrIngredients());
                cocktailEntity = cocktailRepository.save(newCocktailEntity);
           } //else {
//             //update name and ingredients on database in case it exists
//                //System.out.println("cocktail on database");
//                cocktailEntity.setName(drinkResource.getStrDrink());
//                //cocktailEntity.setIngredients(this.getIngredients(drinkResource));
//                cocktailRepository.save(cocktailEntity);
//            }
            //fill cocktailresource for return (mix of db and API-call)
            System.out.println("fill cocktailresource");
            CocktailResource cocktailResource = new CocktailResource();
            cocktailResource.setCocktailId(cocktailEntity.getCocktailId());
            cocktailResource.setName(cocktailEntity.getName());
            cocktailResource.setGlass(drinkResource.getStrGlass());
            cocktailResource.setInstructions(drinkResource.getStrInstructions());
            cocktailResource.setImage(drinkResource.getStrDrinkThumb());
            //cocktailResource.setIngredients(this.getIngredients(drinkResource));
            cocktailResource.setIngredients(drinkResource.getStrIngredients());

            cocktails.add(cocktailResource);
        }

        return cocktails;
    }



}
