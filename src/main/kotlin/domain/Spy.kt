package domain

// Spy class
class Spy(
    override val id: Int,
    override var username: String
) : User {
    override fun displayRole() {
        println("I am a Spy")
    }
}