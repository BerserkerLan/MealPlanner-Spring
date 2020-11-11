package com.rusab.mealplanner

import mu.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

private val logger = KotlinLogging.logger {}

@SpringBootApplication
class MealplannerApplication

	fun main(args: Array<String>) {

		runApplication<MealplannerApplication>(*args)
	}

