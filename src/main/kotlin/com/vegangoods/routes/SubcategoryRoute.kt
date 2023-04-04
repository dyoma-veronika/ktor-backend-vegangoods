package com.vegangoods.routes

import com.vegangoods.data.SubcategoryDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getSubcategoriesByCategory(subcategoryDataSource: SubcategoryDataSource) {
    get("/get-subcategories/{country}/{category}") {
        val countryName = call.parameters["country"] ?: ""
        val categoryName = call.parameters["category"] ?: ""
        call.respond(
            HttpStatusCode.OK,
            subcategoryDataSource.getSubcategoriesByCategory(countryName, categoryName)
        )
    }
}
