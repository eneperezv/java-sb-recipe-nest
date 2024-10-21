package com.enp.recipe.nest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enp.recipe.nest.api.model.RecipeIngredient;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {

}
