package com.rusab.mealplanner.model


data class SearchedRecipe(
        val q: String?,
        val hits: MutableList<Hit>?
)

data class Hit(
        val recipe: Recipe?
)

data class Recipe(
        val label: String?,
        val source: String?,
        val dietLabels: MutableList<String>?,
        val healthLabels: MutableList<String>?,
        val ingredientLines: MutableList<String>,
        val ingredients: MutableList<Ingredient>,
        val calories: Int?
)

data class Ingredient(
        val text: String?,
        val weight: Int?,
        val image: String?
)