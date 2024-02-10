package com.therecipe.recipes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RecipeMsApplication

fun main(args: Array<String>) {
	runApplication<RecipeMsApplication>(*args)
}
