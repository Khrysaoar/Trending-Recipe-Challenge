package com.recipe.recipe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.recipe.model.Recipe;
import com.recipe.recipe.service.RecipeService;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    
    private final RecipeService recipeService = new RecipeService();
    
    @GetMapping("/trending")
    public List<Recipe> getTrendingRecipes() {
        return recipeService.getTrendingRecipes();
    }

    @GetMapping("/trending/filter")
    public List<Recipe> getTrendingRecipesByDifficulty(@RequestParam(required = false) String difficulty) {
        if (difficulty == null || difficulty.isBlank()) {
            throw new IllegalArgumentException("A difficulty is required for filtering trending recipes");
        }
        return recipeService.getTrendingRecipesByDifficulty(difficulty);
    }
}
