package com.vegangoods.routes

import com.vegangoods.data.SubcategoryDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getSubcategoriesByCategory(subcategoryDataSource: SubcategoryDataSource) {
    get("/get-subcategories/{country}/{category}") {
        val countryName = call.parameters["country"]
        val categoryName = call.parameters["category"]

        countryName?.let { countryName ->
            categoryName?.let { categoryName ->
                val subcategories = subcategoryDataSource.getSubcategoriesByCategory(countryName, categoryName)
                if (subcategories.isEmpty()) {
                    call.respond("Subcategories not found")
                } else call.respond(HttpStatusCode.OK, subcategories)
            }
        }
    }
}
