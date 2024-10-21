package com.enp.recipe.nest.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.recipe.nest.api.dto.IngredientDto;
import com.enp.recipe.nest.api.dto.UserDto;
import com.enp.recipe.nest.api.model.Ingredient;
import com.enp.recipe.nest.api.model.User;
import com.enp.recipe.nest.api.repository.IngredientRepository;

@Service
public class IngredientService {
	
	@Autowired
	private IngredientRepository ingredientRepository;

	public IngredientDto createUser(IngredientDto ingredientDto) {
		return buildDto(Optional.of(ingredientRepository.save(buildEntity(ingredientDto))));
	}
	
	public Ingredient buildEntity(IngredientDto ingredientDto) {
		Ingredient ingredient = new Ingredient();
		ingredient.setId(ingredientDto.getId());
		ingredient.setName(ingredientDto.getName());
		return ingredient;
	}
	
	public IngredientDto buildDto(Optional<Ingredient> optional) {
		IngredientDto ingredientDto = new IngredientDto();
		ingredientDto.setId(optional.get().getId());
		ingredientDto.setName(optional.get().getName());
		return ingredientDto;
	}

}
