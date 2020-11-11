package com.rusab.mealplanner.service

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.util.JSONPObject
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.rusab.mealplanner.model.SearchedRecipe
import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

private val mapper = ObjectMapper().registerModule(KotlinModule())
private val logger = KotlinLogging.logger { }

@Service
class RecipeRESTService(
        val restTemplate: RestTemplate
) {
    fun findAllRecipesWithKeyword(query: String): String {
        val url = "https://api.edamam.com/search?app_id=${System.getenv("APPID")}&app_key=${System.getenv("APPKEY")}&q=${query}"
        val response = restTemplate.getForObject(url, String::class.java)
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
        val mappedObject = mapper.readValue(response, SearchedRecipe::class.java)
        return mappedObject.toString()
    }
}