package com.therecipe.recipes.dto

import com.therecipe.recipes.model.Recipe

/**
 * This is a sample of Function Extension
 */
fun Recipe.modelToDto():CreateRecipeDto{
    return CreateRecipeDto(
        id,
        name,
        description,
        ingredients,
        imageUrl)
}