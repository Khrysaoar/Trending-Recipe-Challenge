package com.recipe.recipe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.recipe.recipe.model.Recipe;

@Service
public class RecipeService {

    private static final String IMAGE_URL = "https://ddg0cip9uom1w.cloudfront.net/code-challenge/burger.jpg";
    
    public List<Recipe> getTrendingRecipes() {
        return List.of(
            new Recipe(1, "Cheeseburger", "easy", IMAGE_URL),
            new Recipe(2, "Wagyu Burger", "medium", IMAGE_URL),
            new Recipe(3, "Vegan Burger", "hard", IMAGE_URL)
        );
    }

    public List<Recipe> getTrendingRecipesByDifficulty(String difficulty) {
        return getTrendingRecipes().stream()
            .filter(recipe -> recipe.getDifficulty().equalsIgnoreCase(difficulty))
            .toList();
    }
}
