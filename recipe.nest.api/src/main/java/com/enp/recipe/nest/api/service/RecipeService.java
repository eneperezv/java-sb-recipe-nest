package com.enp.recipe.nest.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enp.recipe.nest.api.model.Ingredient;
import com.enp.recipe.nest.api.model.Recipe;
import com.enp.recipe.nest.api.model.RecipeIngredient;

@Service
public class RecipeService {
	
	@Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

    public RecipeDto createRecipe(RecipeDto recipeDTO) {
        Recipe recipe = new Recipe();
        recipe.setTitle(recipeDTO.getTitle());
        recipe.setDescription(recipeDTO.getDescription());

        // Convertir DTOs de RecipeIngredient a entidades y asignarlas a la receta
        List<RecipeIngredient> recipeIngredients = recipeDTO.getIngredients().stream()
            .map(dto -> {
                Ingredient ingredient = ingredientRepository.findById(dto.getIngredientId())
                    .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found with ID: " + dto.getIngredientId()));

                RecipeIngredient recipeIngredient = new RecipeIngredient();
                recipeIngredient.setRecipe(recipe);
                recipeIngredient.setIngredient(ingredient);
                recipeIngredient.setQuantity(dto.getQuantity());
                return recipeIngredient;
            })
            .collect(Collectors.toList());

        recipe.setRecipeIngredients(recipeIngredients);
        recipeRepository.save(recipe);

        return convertToDTO(recipe);
    }

    public RecipeDto getRecipeById(Long id) {
        Recipe recipe = recipeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with ID: " + id));
        return convertToDTO(recipe);
    }

    private RecipeDto convertToDTO(Recipe recipe) {
        List<RecipeIngredientDto> ingredients = recipe.getRecipeIngredients().stream()
            .map(ri -> new RecipeIngredientDTO(
                ri.getIngredient().getId(),
                ri.getIngredient().getName(),
                ri.getQuantity()))
            .collect(Collectors.toList());

        return new RecipeDto(recipe.getId(), recipe.getTitle(), recipe.getDescription(), ingredients);
    }

}
