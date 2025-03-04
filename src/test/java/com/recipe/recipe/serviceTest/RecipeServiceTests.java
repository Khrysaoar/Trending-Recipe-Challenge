package com.recipe.recipe.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.recipe.recipe.model.Recipe;
import com.recipe.recipe.service.RecipeService;

@SpringBootTest
class RecipeServiceTests {
	
	private final RecipeService recipeService = new RecipeService();

	@Test
	void testGetTrendingRecipes() {
		List<Recipe> recipes = recipeService.getTrendingRecipes();
		assertEquals(3, recipes.size());
	}

	@Test
	void testGetTrendingRecipesByDifficulty() {
		List<Recipe> easyRecipes = recipeService.getTrendingRecipesByDifficulty("easy");
		assertEquals(1, easyRecipes.size());
		assertEquals("Cheeseburger", easyRecipes.get(0).getName());
	}

	@Test
	void testGetTrendingRecipesByDifficultyWithException() {
		List<Recipe> easyRecipes = recipeService.getTrendingRecipesByDifficulty("");
		assertEquals(0, easyRecipes.size());
	}

}
