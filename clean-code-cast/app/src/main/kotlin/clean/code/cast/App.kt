package clean.code.cast

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.netty.Netty
import io.ktor.server.engine.embeddedServer

class Response(val message: String) {}

fun main() {
    embeddedServer(Netty, 8081) {
        routing {
            get("/") {
                println("home access")
                call.respondText("{\"message\":\"Hello from ktor\"}") // , "application/json")
            }
            get("/u/{login}") {
                call.respondText("Hello, ${call.parameters["login"]}")
            }
        }
    }.start(wait = true)
}
