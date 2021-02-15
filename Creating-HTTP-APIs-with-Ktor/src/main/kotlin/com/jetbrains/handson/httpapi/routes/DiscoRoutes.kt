import io.ktor.routing.*

fun Route.discoRouting() {
    route("/disco") {
        get {
            if (discoStorage.isNotEmpty()) {
                call.respond(discoStorage)
            } else {
                call.respondText("No disco found", status = HttpStatusCode.NotFound)
            }
        }
        get("{id}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing or malformed id",
                status = HttpStatusCode.BadRequest
            )
            val disco = discoStorage.find { it.id == id } ?: return@get call.respondText(
                    "No disco with id $id",
                    status = HttpStatusCode.NotFound
                )
            call.respond(disco)
        }
        post {
            val disco = call.receive<Disco>()
            discoStorage.add(disco)
            call.respondText("Disco stored correctly", status = HttpStatusCode.Accepted)
        }
        delete("{id}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if (discoStorage.removeIf { it.id == id }) {
                call.respondText("Disco removed correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Not Found", status = HttpStatusCode.NotFound)
        }
    }
}

fun Application.registerDiscoRoutes() {
    routing {
        discoRouting()
    }
}
