package com.enp.recipe.nest.api.dto;

/*
 * @(#)RecipeDto.java 1.0 12/10/2024
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

import java.util.List;

public class RecipeDto {
	
	private Long id;
    private String title;
    private String description;
    private UserDto user;
    private List<RecipeIngredientDto> ingredients;
    
    public RecipeDto() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public List<RecipeIngredientDto> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<RecipeIngredientDto> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "RecipeDto [id=" + id + ", title=" + title + ", description=" + description + ", user=" + user
				+ ", ingredients=" + ingredients + "]";
	}

}
