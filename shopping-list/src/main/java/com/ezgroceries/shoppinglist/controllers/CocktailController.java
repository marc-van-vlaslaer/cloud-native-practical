package com.ezgroceries.shoppinglist.controllers;

import com.ezgroceries.shoppinglist.resources.CocktailResource;
import com.ezgroceries.shoppinglist.services.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cocktails", produces = "application/json")
public class CocktailController {

    @Autowired
    private CocktailService cocktailService;

    public CocktailController(CocktailService cocktailService) {
        this.cocktailService = cocktailService;
    }

    @GetMapping
    public List<CocktailResource> get(@RequestParam String search) {
        return cocktailService.searchCocktail(search);
    }

//    @GetMapping
//    public List<CocktailResource> get(@RequestParam String search) {
//        return cocktailService.getAllCocktails();
//    }

    }


