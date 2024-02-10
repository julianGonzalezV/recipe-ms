package com.therecipe.recipes.dto;


data class FilterRecipeDto(val nameFilter: String,
                           val descriptionFilter: String,
                           val ingredientsFilter:List<String>) {

    override fun toString(): String {
        return "FilterRecipeDto(nameFilter='$nameFilter', " +
                "descriptionFilter='$descriptionFilter', " +
                "ingredientsFilter=$ingredientsFilter)"
    }
}
