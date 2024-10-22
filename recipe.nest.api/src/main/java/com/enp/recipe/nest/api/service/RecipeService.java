package com.enp.recipe.nest.api.service;

/*
 * @(#)RecipeService.java 1.0 12/10/2024
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

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.recipe.nest.api.dto.RecipeDto;
import com.enp.recipe.nest.api.model.Recipe;
import com.enp.recipe.nest.api.repository.RecipeRepository;

@Service
public class RecipeService {
	
	@Autowired
    private RecipeRepository recipeRepository;
	
	public RecipeDto createUser(RecipeDto recipeDto) {
		return buildDto(Optional.of(recipeRepository.save(buildEntity(recipeDto))));
	}
	
	public Recipe buildEntity(RecipeDto recipeDto) {
		Recipe recipe = new Recipe();
		recipe.setId(recipeDto.getId());
		recipe.setTitle(recipeDto.getTitle());
		recipe.setDescription(recipeDto.getDescription());
		recipe.setUser(recipeDto.getUser());
		return recipe;
	}
	
	public RecipeDto buildDto(Optional<Recipe> optional) {
		RecipeDto recipeDto = new RecipeDto();
		recipeDto.setId(optional.get().getId());
		recipeDto.setTitle(optional.get().getTitle());
		recipeDto.setDescription(optional.get().getDescription());
		recipeDto.setUser(optional.get().getUser());
		return recipeDto;
	}

}
