package com.rusab.mealplanner.controller

import com.rusab.mealplanner.service.RecipeRESTService
import mu.KotlinLogging
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

val logger = KotlinLogging.logger { }

@Controller
class IndexController(
        val recipeRESTService: RecipeRESTService
) {

    @GetMapping("/")
    fun index():String {
        logger.info { recipeRESTService.findAllRecipesWithKeyword("biryani") }
        return "index"
    }

    @GetMapping("/search/")
    fun getRecipesBySearch() {

    }
}