package com.vegangoods.routes

import com.vegangoods.data.CountryDataSource
import com.vegangoods.data.model.Country
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllCountries(countryDataSource: CountryDataSource) {
    get("/get-countries") {
        val countries = countryDataSource.getAllCountries()
        if (countries.isEmpty()) {
            call.respond("Countries not found")
        } else call.respond(HttpStatusCode.OK, countries)
    }
}

fun Route.addCountry(countryDataSource: CountryDataSource) {
    post("/add-country") {
        val request = try {
            call.receive<Country>()
        } catch (e: ContentTransformationException) {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }
        countryDataSource.addCountry(request)
        call.respond(
            HttpStatusCode.OK,
            "Country successfully added"
        )
    }
}
