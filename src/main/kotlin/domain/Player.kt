package domain

// Player class
class Player(
    id: Int,
    username: String
) : User(
    id,
    username
){
    override fun displayRole() {
        println("I am a player")
    }
}





