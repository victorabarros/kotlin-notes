package com.example

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {
        get("/") { call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain) }
        get("/hello") {
            println("hello")
            call.respondText(
                    "{\"HELLO\": \"WORLD!\"}",
                    contentType = ContentType.Application.Json,
                    status = HttpStatusCode.Accepted)
        }
    }
}
