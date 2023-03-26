package com.vegangoods.routes

import com.vegangoods.data.CategoryDataSource
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.getCategoriesByCountry(categoryDataSource: CategoryDataSource) {
    get("/categories/{country}") {
        val countryName = call.request.queryParameters["country"].toString()
        call.respond(
            HttpStatusCode.OK,
            categoryDataSource.getCategoriesByCountry(countryName)
        )
    }
}
