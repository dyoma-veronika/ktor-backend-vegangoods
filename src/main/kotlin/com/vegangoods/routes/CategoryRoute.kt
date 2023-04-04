package com.vegangoods.routes

import com.vegangoods.data.CategoryDataSource
import com.vegangoods.data.model.Category
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.getCategoriesByCountry(categoryDataSource: CategoryDataSource) {
    route("/get-categories") {
        get("/{countryName}") {
            val countryName = call.parameters["countryName"] ?: ""
            val categories = categoryDataSource.getCategoriesByCountry(countryName)
            call.respond(
                HttpStatusCode.OK,
                categories
            )
        }
    }
}

fun Route.addCategory(categoryDataSource: CategoryDataSource) {
    route("/add-category") {
        post {
            val request = try {
                call.receive<Category>()
            } catch (e: ContentTransformationException) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }
            categoryDataSource.addCategory(request)
            call.respond(
                HttpStatusCode.OK,
                "Category successfully created"
            )
        }
    }
}
