import kotlinx.serialization.Serializable

val trackStorage = listOf(Track(
    "uuid", "Powerslave", listOf(
        Author("uuid", "Harris", "Bass")
    )),
    Track("uuid", "2 Minutes to Midnight", listOf(
        Author("uuid", "Dickinson", "Vocal"),
        Author("uuid", "Smith", "Guitar")
    ))
)

@Serializable
data class Track(val id: String, val name: String, val authors: List<Author>)

@Serializable
data class Author(val id: String, val name: String, val role: String)
