package com.vegangoods

import com.vegangoods.di.mainModule
import com.vegangoods.plugins.*
import io.ktor.server.application.*
import io.ktor.util.*
import org.koin.*
import org.koin.core.context.startKoin

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    startKoin {
        modules(mainModule)
    }
    configureSerialization()
    configureMonitoring()
    configureRouting()
}
