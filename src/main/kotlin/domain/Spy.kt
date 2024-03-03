package domain

// Spy class
class Spy(
    id: Int,
    username: String
) : User(id, username) {
    // Additional properties and methods specific to spies can be added here
    override fun displaRole() {
        println("I am a Spy")
    }
}