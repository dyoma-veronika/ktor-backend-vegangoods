package com.vegangoods.routes

import com.vegangoods.data.ItemDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getItemsBySubcategory(itemDataSource: ItemDataSource) {
    get("/get-items/{country}/{category}/{subcategory}") {
        val subcategoryName = call.parameters["subcategory"]
        val categoryName = call.parameters["category"]
        val countryName = call.parameters["country"]

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
