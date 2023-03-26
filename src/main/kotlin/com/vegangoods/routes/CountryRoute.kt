package com.vegangoods.routes

import com.vegangoods.data.CountryDataSource
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

private const val BASE_URL = "http://localhost:8080"

fun Route.getAllCountries(countryDataSource: CountryDataSource) {
    get("/countries") {
        call.respond(
            HttpStatusCode.OK,
            countryDataSource.getAllCountries()
        )
    }
}
