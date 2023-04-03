package com.vegangoods.routes

import com.vegangoods.data.CategoryDataSource
import com.vegangoods.data.CategoryRequest
import com.vegangoods.data.SimpleResponse
import com.vegangoods.data.model.Category
import com.vegangoods.data.model.Country
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.getCategoriesByCountry(categoryDataSource: CategoryDataSource) {
    route("/get-categories") {
        get {
            val countryName = call.receive<CategoryRequest>().countryName
            val categories = categoryDataSource.getCategoriesByCountry(countryName)
            categories?.let {
                call.respond(
                    HttpStatusCode.OK,
                    SimpleResponse(true, "successfully retrieved", it)
                )
            } ?: call.respond(
                HttpStatusCode.OK,
                SimpleResponse(true, "There is no employee with this id", Unit)

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
                SimpleResponse(true, "Category successfully created", Unit)
            )
        }
    }
}
