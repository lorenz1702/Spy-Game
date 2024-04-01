package domain

// Player class
class Player(
    override val id: Int,
    override var username: String
) : User {
    override fun displayRole() {
        println("I am a Player")
    }
}





