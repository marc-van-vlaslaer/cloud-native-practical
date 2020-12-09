package com.ezgroceries.shoppinglist.services;

import com.ezgroceries.shoppinglist.entities.CocktailEntity;
import com.ezgroceries.shoppinglist.entities.ShoppingListEntity;
import com.ezgroceries.shoppinglist.repositories.CocktailRepository;
import com.ezgroceries.shoppinglist.repositories.ShoppingListRepository;
import com.ezgroceries.shoppinglist.resources.CocktailResource;
import com.ezgroceries.shoppinglist.resources.ShoppingListResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ShoppingListService {

    @Autowired
    private final ShoppingListRepository shoppingListRepository;

    @Autowired
    private final CocktailRepository cocktailRepository;

    public ShoppingListService(ShoppingListRepository shoppingListEntityRepository, CocktailRepository cocktailRepository) {
        this.shoppingListRepository = shoppingListEntityRepository;
        this.cocktailRepository = cocktailRepository;
    }


     public ShoppingListResource addShoppingList(ShoppingListResource shoppingListResource) {
        ShoppingListEntity shoppingListEntitySave = new ShoppingListEntity();
        shoppingListEntitySave.setName(shoppingListResource.getName());
        shoppingListEntitySave.setShoppingListId(UUID.randomUUID());
        shoppingListRepository.save(shoppingListEntitySave);
        ShoppingListResource addedShoppingListResource = new ShoppingListResource();
        addedShoppingListResource.setName(shoppingListEntitySave.getName());
        addedShoppingListResource.setShoppingListId(shoppingListEntitySave.getShoppingListId());

        return addedShoppingListResource;

    }

    public List<ShoppingListResource> getAllShoppingLists() {
        List<ShoppingListEntity> shoppingListEntities = new ArrayList<>();
        shoppingListRepository.findAll().forEach(shoppingListEntities::add);
        List<ShoppingListResource> shoppingLists = new ArrayList<>();
        for (int i = 0 ; i < shoppingListEntities.size() ; i++){
            ShoppingListResource shoppingListResource = new ShoppingListResource();
            shoppingListResource.setShoppingListId(shoppingListEntities.get(i).getShoppingListId());
            shoppingListResource.setName(shoppingListEntities.get(i).getName());
            List<CocktailEntity> cocktailEntities = shoppingListEntities.get(i).getCocktailEntities();
            //TO DO : find a way to return all ingredients
            for (int c = 0 ; c < cocktailEntities.size() ; c++){
                shoppingListResource.setIngredients(cocktailEntities.get(c).getIngredients());
            }
            shoppingLists.add(shoppingListResource);

        }
        return shoppingLists;
    }

    public Optional<ShoppingListResource> getShoppingList(UUID shoppingListId) {
        Optional<ShoppingListEntity> shoppingListEntity = shoppingListRepository.findById(shoppingListId);
        ShoppingListResource shoppingListResource = new ShoppingListResource();
        shoppingListResource.setShoppingListId(shoppingListEntity.get().getShoppingListId());
        shoppingListResource.setName(shoppingListEntity.get().getName());
        List<CocktailEntity> cocktailEntities = shoppingListEntity.get().getCocktailEntities();
        //TO DO : find a way to return all ingredients
        for (int c = 0 ; c < cocktailEntities.size() ; c++){
            shoppingListResource.setIngredients(cocktailEntities.get(c).getIngredients());
        }
        return Optional.of(shoppingListResource);

    }

    public ShoppingListResource addCocktailsToShoppingList(String shoppingListId, List<CocktailResource> cocktails) {
        ShoppingListEntity shoppingListEntity = shoppingListRepository.findById(UUID.fromString(shoppingListId)).get();
        //check if shoppinglist exists
        if (shoppingListEntity == null) {
            throw new RuntimeException("shopping list not found");
        }
        List<CocktailEntity> linkedCocktailEntities = shoppingListEntity.getCocktailEntities().stream().collect(Collectors.toList());
        //Loop over all cocktails in request
        for (int i = 0; i < cocktails.size(); i++) {
            CocktailEntity cocktailEntity = cocktailRepository.findById((cocktails.get(i).getCocktailId())).get();
            if (cocktailEntity == null ) {
                throw new RuntimeException("cocktail not found");
            } else if (linkedCocktailEntities.contains(cocktailEntity)){

                } else {
                        shoppingListEntity.getCocktailEntities().add(cocktailEntity);
                    }
        }
        shoppingListRepository.save(shoppingListEntity);

        System.out.println("fill shopping list");
        ShoppingListResource shoppingListResource = new ShoppingListResource();
        shoppingListResource.setShoppingListId(shoppingListEntity.getShoppingListId());
        shoppingListResource.setName(shoppingListEntity.getName());
        return shoppingListResource;


    }

}







