package domain

interface User {
    val id: Int
    var username: String
    fun displayRole()
}


interface DisplayRoleUseCase{
    fun displayRole(User: User)
}