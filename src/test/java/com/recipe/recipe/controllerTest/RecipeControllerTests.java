package com.recipe.recipe.controllerTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.recipe.recipe.controller.RecipeController;
import com.recipe.recipe.service.RecipeService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RecipeController.class)
public class RecipeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
    @MockBean
    private RecipeService recipeService;

    @Test
    void testGetTrendingRecipes() throws Exception {
        mockMvc.perform(get("/api/recipes/trending"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(3))
                .andExpect(jsonPath("$[0].name").value("Cheeseburger"))
                .andExpect(jsonPath("$[0].difficulty").value("easy"));
    }

    @Test
    void testGetTrendingRecipesByDifficulty_Success() throws Exception {
        mockMvc.perform(get("/api/recipes/trending/filter")
                        .param("difficulty", "easy"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].name").value("Cheeseburger"))
                .andExpect(jsonPath("$[0].difficulty").value("easy"));
    }

    @Test
    void testGetTrendingRecipesByDifficulty_MissingParam() throws Exception {
        mockMvc.perform(get("/api/recipes/trending/filter"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("A difficulty is required for filtering trending recipes"));
    }
}
