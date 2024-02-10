package com.therecipe.recipes.repository

import org.springframework.data.mongodb.repository.Query


import com.therecipe.recipes.model.Recipe
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Implementing MongoRepository enables the class to use all available functions coming from Mongo spring data
 */
interface RecipeRepository: MongoRepository<Recipe, String>{

    @Query("{'name': {\$regex : ?0, \$options: 'i'}}")
    fun findByNameRegex(name:String?):Iterable<Recipe>
}