package com.vegangoods.routes

import com.vegangoods.data.CountryDataSource
import com.vegangoods.data.SimpleResponse
import com.vegangoods.data.model.Country
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllCountries(countryDataSource: CountryDataSource) {
    route("/get-countries") {
        get {
            val countries = countryDataSource.getAllCountries()
            call.respond(
                HttpStatusCode.OK,
                countries
                //SimpleResponse(true, "Countries successfully retrieved", countries)
            )
        }
    }
}

fun Route.addCountry(countryDataSource: CountryDataSource) {
    route("/add-country") {
        post {
            val request = try {
                call.receive<Country>()
            } catch (e: ContentTransformationException) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }
            countryDataSource.addCountry(request)
            call.respond(
                HttpStatusCode.OK,
                SimpleResponse(true, "Country successfully created", Unit))
        }
    }
}
