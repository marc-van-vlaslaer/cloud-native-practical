package com.ezgroceries.shoppinglist.controllers;

import com.ezgroceries.shoppinglist.services.CocktailService;
import com.ezgroceries.shoppinglist.services.ShoppingListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ShoppingListController.class)
public class ShoppingListControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShoppingListService shoppingListService;
    @MockBean
    private CocktailService cocktailService;

//    @Before
//    public void setUp() throws Exception {
//        mockMvc = MockMvcBuilders.standaloneSetup(shoppingListService).build();
//
//    }

    @Test
    public void testShoppingList() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/shopping-lists"))
                .andExpect(status().isOk()) ;
    }

//    @Test
//    public void testShoppingListJson() throws Exception {
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/shopping-lists")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Marc")));

 //   }




}