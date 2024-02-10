package com.therecipe.recipes.dto;

import com.therecipe.recipes.model.Recipe

data class CreateRecipeDto(val name: String,
                           val description: String,
                           val ingredients:List<String>,
                           val imageUrl:String) {

    constructor(recipe: Recipe): this(recipe.name, recipe.description,recipe.ingredients,recipe.imageUrl)

    init {
        require(name.length >1) { "Please provide a name to the recipe" }
        require(ingredients.isNotEmpty()) { "Please provide a name to the recipe" }
    }

    override fun toString(): String {
        return "RecipeDto(name='$name', description='$description', ingredients=$ingredients, imageUrl='$imageUrl')"
    }
}
