package com.vegangoods.routes

import com.vegangoods.data.ShopDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getShopsByCountry(shopDataSource: ShopDataSource) {
    get("/shops/{country}") {
        val countryName = call.request.queryParameters["country"].toString() //check all nullable situations. exceptions
        call.respond(
            HttpStatusCode.OK,
            shopDataSource.getShopsByCountry(countryName)
        )
    }
}
