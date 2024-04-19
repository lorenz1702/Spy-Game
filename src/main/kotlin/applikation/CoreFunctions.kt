package applikation

import domain.User

interface CoreFunctions {
    fun NumberOfUsers(UserNumber: Int)

    fun NumberOfSpys(SpyNumber:Int)

    fun getCategory():List<String>

    fun setCategories(chosenCategories:List<Boolean>)

    fun StartGame()

    fun DisplayOneRole()

    fun StartTimer()

    fun EndGame()

}