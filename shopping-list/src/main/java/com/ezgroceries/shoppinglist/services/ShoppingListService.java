package com.ezgroceries.shoppinglist.services;

import com.ezgroceries.shoppinglist.model.ShoppingList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class ShoppingListService {

 //   private static List<ShoppingList> shoppingLists = new ArrayList<>();
    private static List<ShoppingList> shoppingLists = new ArrayList<>(Arrays.asList(
            new ShoppingList("Marc"),
            new ShoppingList("Maria")

    ));

    public static List<ShoppingList> getAllShoppingLists() {
        return shoppingLists;
    }

    public ShoppingList getShoppingList (UUID shoppingListId){
        return shoppingLists.stream().filter(t -> t.getShoppingListId().equals(shoppingListId)).findFirst().get();
    }

    public ShoppingList addShoppingList(ShoppingList shoppingList) {
        shoppingList.setShoppingListId(UUID.randomUUID());
        shoppingLists.add(shoppingList);
        return shoppingList;
    }

    public void updateShoppingList(UUID shoppingListId, ShoppingList shoppingList) {
        for (int i = 0; i < shoppingLists.size(); i++){
            ShoppingList s = shoppingLists.get(i);
            if (s.getShoppingListId().equals(shoppingListId)){
                shoppingLists.set(i,shoppingList);
                return;
            }
        }
    }

    public void addIngredients(UUID shoppingListId, List<String> ingredients) {
        ShoppingList s = getShoppingList(shoppingListId);
        for (int ing = 0; ing < ingredients.size(); ing++) {
            s.addIngredient(s, ingredients.get(ing));
        }
        return;
    }

//        for (int i = 0; i < shoppingLists.size(); i++){
//            ShoppingList s = shoppingLists.get(i);
//            if (s.getShoppingListId().equals(shoppingListId)){
//                for (int ing = 0; ing < ingredients.size(); ing++){
//                    s.addIngredient(s, ingredients.get(ing));
//                }
//                return;
//            }
//        }
//    }


    public void deleteShoppingList(UUID shoppingListId) {
        shoppingLists.removeIf(t -> t.getShoppingListId().equals(shoppingListId));
    }
}
