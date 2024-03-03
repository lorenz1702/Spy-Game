package domain

// Player class
class Player(
    id: Int,
    username: String
) : User(
    id,
    username
){
    override fun displaRole() {
        println("I am a player")
    }
}





