package com.vegangoods.routes

import com.vegangoods.data.SubcategoryDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getSubcategoriesByCategory(subcategoryDataSource: SubcategoryDataSource) {
    get("/subcategories/{category}") {
        val categoryName = call.request.queryParameters["category"].toString()
        call.respond(
            HttpStatusCode.OK,
            subcategoryDataSource.getSubcategoriesByCategory(categoryName)
        )
    }
}
