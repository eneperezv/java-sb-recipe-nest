package com.enp.recipe.nest.api.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enp.recipe.nest.api.dto.IngredientDto;
import com.enp.recipe.nest.api.dto.UserDto;
import com.enp.recipe.nest.api.model.ErrorDetails;
import com.enp.recipe.nest.api.model.ResponseDetails;
import com.enp.recipe.nest.api.service.IngredientService;

@RestController
@RequestMapping("/api/v1/recipenest/ingredients")
public class IngredientController {
	
	@Autowired
	private IngredientService ingredientService;
	
	@PostMapping()
	public ResponseDetails<?> createIngredient(@RequestBody IngredientDto ingredientDto) {
		IngredientDto savedIngredientDto;
		try{
			savedIngredientDto = ingredientService.createUser(ingredientDto);
			if(savedIngredientDto == null) {
				ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.NOT_FOUND.toString(),"Ingredient <"+savedIngredientDto+"> not created.");
				return new ResponseDetails<String>("ERROR",new Date(),new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND));
			}
			return new ResponseDetails<IngredientDto>("OK",new Date(),new ResponseEntity<IngredientDto>(savedIngredientDto, HttpStatus.OK));
		}catch(Exception e){
			ErrorDetails err = new ErrorDetails(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage());
			return new ResponseDetails<ErrorDetails>("ERROR",new Date(),new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}

}
