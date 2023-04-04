package com.vegangoods.routes

import com.vegangoods.data.ShopDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getShopsByCountry(shopDataSource: ShopDataSource) {
    get("/get-shops/{country}") {
        val countryName = call.parameters["country"]
        countryName?.let {
            val shops = shopDataSource.getShopsByCountry(it)
            if (shops.isEmpty()) {
                call.respond("No shops found")
            } else call.respond(HttpStatusCode.OK, shops)
        }
    }
}
