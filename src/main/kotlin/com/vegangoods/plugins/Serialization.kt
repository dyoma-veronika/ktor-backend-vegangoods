package com.vegangoods.plugins

import io.ktor.features.*
import io.ktor.application.*
import org.litote.kmongo.json

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json
    }
}
