package com.enp.recipe.nest.api.service;

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
