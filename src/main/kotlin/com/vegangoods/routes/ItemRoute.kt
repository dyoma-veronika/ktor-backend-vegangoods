package com.vegangoods.routes

import com.vegangoods.data.ItemDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getItemsBySubcategory(itemDataSource: ItemDataSource) {
    get("/get-items/{countryName}/{categoryName}/{subcategoryName}") {
        val subcategoryName = call.parameters["subcategoryName"]
        val categoryName = call.parameters["categoryName"]
        val countryName = call.parameters["countryName"]

        countryName?.let { countryName ->
            categoryName?.let { categoryName ->
                subcategoryName?.let { subcategoryName ->
                    val items = itemDataSource.getItemsBySubcategory(countryName, categoryName, subcategoryName)
                    if (items.isEmpty()) {
                        call.respond("Items not found")
                    } else call.respond(HttpStatusCode.OK, items)
                }
            }
        }
    }
}
