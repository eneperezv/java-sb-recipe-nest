package com.enp.recipe.nest.api.dto;

/*
 * @(#)IngredientDto.java 1.0 12/10/2024
 * 
 * El código implementado en este formulario esta protegido
 * bajo las leyes internacionales del Derecho de Autor, sin embargo
 * se entrega bajo las condiciones de la General Public License (GNU GPLv3)
 * descrita en https://www.gnu.org/licenses/gpl-3.0.html
 */

/**
 * Clase controller para gestion de reservas
 *
 * @author eliezer.navarro
 * @version 1.0
 * @since 1.0
 */

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
