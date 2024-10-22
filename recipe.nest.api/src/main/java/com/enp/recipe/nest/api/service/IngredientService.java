package com.enp.recipe.nest.api.service;

/*
 * @(#)IngredientService.java 1.0 12/10/2024
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

import com.enp.recipe.nest.api.dto.IngredientDto;
import com.enp.recipe.nest.api.model.Ingredient;
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
