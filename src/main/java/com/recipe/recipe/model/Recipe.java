package com.recipe.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Recipe {
    private int position;
    private String name;
    private String difficulty;
    private String imageUrl;
}
