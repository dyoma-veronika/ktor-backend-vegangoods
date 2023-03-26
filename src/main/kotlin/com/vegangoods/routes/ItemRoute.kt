package com.vegangoods.routes

import com.vegangoods.data.ItemDataSource
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

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
