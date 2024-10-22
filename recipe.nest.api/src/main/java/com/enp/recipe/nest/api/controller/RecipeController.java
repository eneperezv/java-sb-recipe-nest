package com.enp.recipe.nest.api.controller;

/*
 * @(#)RecipeController.java 1.0 12/10/2024
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

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enp.recipe.nest.api.dto.RecipeDto;
import com.enp.recipe.nest.api.model.ErrorDetails;
import com.enp.recipe.nest.api.model.ResponseDetails;
import com.enp.recipe.nest.api.service.RecipeService;

@RestController
@RequestMapping("/api/v1/recipenest/recipes")
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	@PostMapping("/create")
	public ResponseDetails<?> createRecipe(@RequestBody RecipeDto recipeDto) {
		RecipeDto savedRecipeDto;
		try{
			savedRecipeDto = recipeService.createUser(recipeDto);
			if(savedRecipeDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"Recipe <"+savedRecipeDto+"> not created.");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			return new ResponseDetails<RecipeDto>("OK",new Date(),new ResponseEntity<RecipeDto>(savedRecipeDto, HttpStatus.OK));
		}catch(Exception e){
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}

}
