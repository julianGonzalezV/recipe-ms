package com.therecipe.recipes.service

import com.therecipe.recipes.dto.CreateRecipeDto
import com.therecipe.recipes.model.Recipe
import com.therecipe.recipes.repository.RecipeRepository
import org.springframework.stereotype.Service

@Service
class RecipeService(private val recipeRepo: RecipeRepository) {

    fun getRecipes():Iterable<CreateRecipeDto> = recipeRepo.findAll().map { item -> CreateRecipeDto(item) }

    fun getRecipesMatch(name:String?):Iterable<CreateRecipeDto> =
        recipeRepo.findByNameRegex(name).map { item -> CreateRecipeDto(item) }

    fun createRecipe(recipe: Recipe):CreateRecipeDto {
        val createdRecipe = recipeRepo.save(recipe)
        return CreateRecipeDto(createdRecipe)
    }
}