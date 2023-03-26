package com.vegangoods.routes

import com.vegangoods.data.CountryDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val BASE_URL = "http://localhost:8080"

fun Route.getAllCountries(countryDataSource: CountryDataSource) {
    get("/countries") {
        call.respond(
            HttpStatusCode.OK,
            countryDataSource.getAllCountries()
        )
    }
}
