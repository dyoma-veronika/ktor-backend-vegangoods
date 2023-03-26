package com.vegangoods.routes

import com.vegangoods.data.ItemDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getItemsBySubcategory(itemDataSource: ItemDataSource) {
    get("/items/{subcategory}") {
        val subcategoryName = call.request.queryParameters["subcategory"].toString()
        call.respond(
            HttpStatusCode.OK,
            itemDataSource.getItemsBySubcategory(subcategoryName)
        )
    }
}

fun Route.getItemsByCategory(itemDataSource: ItemDataSource) {
    get("/items/{category}") {
        val categoryName = call.request.queryParameters["category"].toString()
        call.respond(
            HttpStatusCode.OK,
            itemDataSource.getItemsByCategory(categoryName)
        )
    }
}
