package com.jetbrains.handson.httpapi

import io.ktor.application.Application
import kotlinx.coroutines.*
import io.ktor.application.*
import io.ktor.content.TextContent
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.util.*
import java.io.*
import java.time.*
import java.util.*
import java.util.concurrent.*



fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    registerDiscoRoutes()
    registerTrackRoutes()
}
