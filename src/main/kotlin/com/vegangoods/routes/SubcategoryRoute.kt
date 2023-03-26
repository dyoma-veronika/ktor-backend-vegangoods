package com.vegangoods.routes

import com.vegangoods.data.SubcategoryDataSource
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.getSubcategoriesByCategory(subcategoryDataSource: SubcategoryDataSource) {
    get("/subcategories/{category}") {
        val categoryName = call.request.queryParameters["category"].toString()
        call.respond(
            HttpStatusCode.OK,
            subcategoryDataSource.getSubcategoriesByCategory(categoryName)
        )
    }
}
