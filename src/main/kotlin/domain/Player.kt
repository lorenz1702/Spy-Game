package applikation

// Player class
data class Player(
    val id: Int,
    val username: String
) : User(
    id,
    username
)