package domain

open class User (
    val id: Int,
    var username: String
){
    open fun displaRole(){
        println("I am a user")
    }
}

interface DisplayRoleUseCase{
    fun displayrole(User: User)
}