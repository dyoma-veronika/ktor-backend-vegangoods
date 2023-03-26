package com.vegangoods.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import org.litote.kmongo.json

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json
    }
}
