package com.vegangoods.routes

import com.vegangoods.data.CategoryDataSource
import com.vegangoods.data.model.Category
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllCategories(categoryDataSource: CategoryDataSource) {
    get("/get-all-categories") {
        val categories = categoryDataSource.getAllCategories()
        if (categories.isEmpty()) {
            call.respond("Countries not found")
        } else call.respond(HttpStatusCode.OK, categories)
    }
}

fun Route.getCategoriesByCountry(categoryDataSource: CategoryDataSource) {
    get("/get-categories/{countryName}") {
        val countryName = call.parameters["countryName"]
        countryName?.let {
            val categories = categoryDataSource.getCategoriesByCountry(it)
            if (categories.isEmpty()) {
                call.respond("Categories not found")
            } else call.respond(HttpStatusCode.OK, categories)
        }
    }
}

fun Route.addCategory(categoryDataSource: CategoryDataSource) {
    post("/add-category") {
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
