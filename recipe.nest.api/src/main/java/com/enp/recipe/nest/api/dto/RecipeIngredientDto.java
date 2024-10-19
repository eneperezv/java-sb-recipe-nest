package com.enp.recipe.nest.api.dto;

public class RecipeIngredientDto {
	
	private Long ingredientId;
    private String ingredientName;
    private String quantity;
    
    public RecipeIngredientDto() {
    	
    }

	public Long getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(Long ingredientId) {
		this.ingredientId = ingredientId;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "RecipeIngredientDto [ingredientId=" + ingredientId + ", ingredientName=" + ingredientName
				+ ", quantity=" + quantity + "]";
	}

}
