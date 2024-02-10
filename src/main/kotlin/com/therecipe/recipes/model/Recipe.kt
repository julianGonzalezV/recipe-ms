package com.therecipe.recipes.model;

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Recipe( @Id val id: String?,
                   val name: String,
                   val description: String,
                   val ingredients:List<String>,
                   val imageUrl:String,) {
    override fun toString(): String {
        return "Recipe(id='$id', name='$name', description='$description', ingredients=$ingredients, imageUrl='$imageUrl')"
    }
}
