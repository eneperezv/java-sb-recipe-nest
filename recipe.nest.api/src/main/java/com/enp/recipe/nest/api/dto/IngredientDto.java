package com.enp.recipe.nest.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.enp.recipe.nest.api.model.RecipeIngredient;

public class IngredientDto {
	
	private Long id;
    private String name;
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RecipeIngredient> getRecipeIngredients() {
		return recipeIngredients;
	}

	public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}

	@Override
	public String toString() {
		return "IngredientDto [id=" + id + ", name=" + name + ", recipeIngredients=" + recipeIngredients + "]";
	}

}
