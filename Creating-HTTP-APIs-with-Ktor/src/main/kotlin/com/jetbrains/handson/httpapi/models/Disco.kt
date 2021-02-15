import kotlinx.serialization.Serializable

val discoStorage = mutableListOf<Disco>(
    Disco("uuid", "Powerslave", "Iron Maiden", 1984)
)

@Serializable
data class Disco(val id: String, val name: String, val group: String, val year: Int)
