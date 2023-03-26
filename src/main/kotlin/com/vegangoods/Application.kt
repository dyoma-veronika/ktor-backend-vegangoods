package com.vegangoods

import com.vegangoods.di.mainModule
import com.vegangoods.plugins.*
import io.ktor.application.*
import org.koin.ktor.ext.Koin
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    install(Koin) {
        modules(mainModule)
    }
    configureSerialization()
    configureMonitoring()
    configureRouting()
}
