import io.ktor.routing.*

fun Route.listTracksRoute() {
    get("/track") {
        if (trackStorage.isNotEmpty()) {
            call.respond(trackStorage)
        }
    }
}

fun Route.getTrackRoute() {
    get("/track/{id}") {
        val id = call.parameters["id"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
        val track = trackStorage.find { it.id == id } ?: return@get call.respondText(
            "Not Found",
            status = HttpStatusCode.NotFound
        )
        call.respond(track)
    }
}

fun Route.tracksAuthorsRoute() {
    get("/track/{id}/authors") {
        val id = call.parameters["id"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
        val track = trackStorage.find { it.id == id } ?: return@get call.respondText(
            "Not Found",
            status = HttpStatusCode.NotFound
        )
        call.respond(track.authors)
    }
}

fun Application.registerTrackRoutes() {
    routing {
        listTracksRoute()
        getTrackRoute()
        tracksAuthorsRoute()
    }
}
