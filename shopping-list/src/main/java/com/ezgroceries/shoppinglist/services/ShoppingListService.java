package com.ezgroceries.shoppinglist.services;

import com.ezgroceries.shoppinglist.entities.CocktailEntity;
import com.ezgroceries.shoppinglist.entities.ShoppingListEntity;
import com.ezgroceries.shoppinglist.model.ShoppingList;
import com.ezgroceries.shoppinglist.repositories.CocktailRepository;
import com.ezgroceries.shoppinglist.repositories.ShoppingListRepository;
import com.ezgroceries.shoppinglist.resources.CocktailResource;
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


    public ShoppingListEntity addShoppingList(ShoppingListEntity shoppingListEntity) {
        ShoppingListEntity shoppingListEntitySave = new ShoppingListEntity();
        shoppingListEntitySave.setName(shoppingListEntity.getName());
        shoppingListEntitySave.setShoppingListId(UUID.randomUUID());
        return shoppingListRepository.save(shoppingListEntitySave);

    }

    public List<ShoppingListEntity> getAllShoppingLists() {
        List<ShoppingListEntity> shoppingListEntities = new ArrayList<>();
        shoppingListRepository.findAll().forEach(shoppingListEntities::add);
        return shoppingListEntities;
    }

    public Optional<ShoppingListEntity> getShoppingList(UUID shoppingListId) {
        return shoppingListRepository.findById(shoppingListId);

    }

    public ShoppingList addCocktailsToShoppingList(String shoppingListId, List<CocktailResource> cocktails) {
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

        //To do shoppinglist teruggeven en opvullen zoals gedaan voor cocktailresource
        System.out.println("fill shopping list");
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setShoppingListId(shoppingListEntity.getShoppingListId());
        shoppingList.setName(shoppingListEntity.getName());
        return shoppingList;


    }

}







