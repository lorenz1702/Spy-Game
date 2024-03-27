package domain

open class User (
    val id: Int,
    var username: String
){
    open fun displayRole(){
        println("I am a user")
    }
}

interface DisplayRoleUseCase{
    fun displayRole(User: User)
}