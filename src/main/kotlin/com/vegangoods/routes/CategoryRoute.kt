package com.vegangoods.routes

import com.vegangoods.data.CategoryDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.getCategoriesByCountry(categoryDataSource: CategoryDataSource) {
    get("/categories/{country}") {
        val countryName = call.request.queryParameters["country"].toString()
        call.respond(
            HttpStatusCode.OK,
            categoryDataSource.getCategoriesByCountry(countryName)
        )
    }
}
