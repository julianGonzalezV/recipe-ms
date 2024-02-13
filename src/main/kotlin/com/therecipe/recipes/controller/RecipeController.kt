package com.therecipe.recipes.controller

import com.therecipe.recipes.dto.CreateRecipeDto
import com.therecipe.recipes.model.Recipe
import com.therecipe.recipes.service.RecipeService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Collections.emptyList
import java.util.Optional

@RestController
@RequestMapping("/api/recipe")
class RecipeController (@Value("\${therecipe.recipes.buildNumber}") val buildNumber: String,
                        private val recipeService: RecipeService) {

    val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/version")
    fun appVersion(): String = buildNumber

    @GetMapping("/{code}")
    fun getByCode(@PathVariable code:String): CreateRecipeDto =
        recipeService.getByCode(code)


    @DeleteMapping("/{code}")
    fun delete(@PathVariable code:String) =
        recipeService.deleteCode(code)


    @GetMapping()
    fun getByName(
        @RequestParam(required = false) name: String?,
    ): Iterable<CreateRecipeDto>{
        val allBlank= listOf(name)
            .all { filter -> filter.isNullOrBlank() }

        if(allBlank){
            return recipeService.getRecipes()
        }

        return recipeService.getRecipesMatch(name)
    }

    @PostMapping
    fun create(@RequestBody request: CreateRecipeDto): CreateRecipeDto {
        logger.info("Creating the recipe: {}", request)
        return recipeService.createRecipe( Recipe(id = null,
            name = request.name,
            description = request.description,
            imageUrl = request.imageUrl,
            ingredients =  Optional.ofNullable(request.ingredients).orElse(emptyList()
            )))
    }

    @PutMapping
    fun update(@RequestBody request: CreateRecipeDto): CreateRecipeDto {
        logger.info("Creating the recipe: {}", request)
        return recipeService.createRecipe( Recipe(
            id = request.code,
            name = request.name,
            description = request.description,
            imageUrl = request.imageUrl,
            ingredients =  Optional.ofNullable(request.ingredients).orElse(emptyList()
            )))
    }
}