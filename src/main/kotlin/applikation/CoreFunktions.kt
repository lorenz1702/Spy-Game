package applikation

import domain.Player
import domain.Spy

interface CoreFunktions {
    fun NumberOfUsers(UserNumber: Int)

    fun NumberOfSpys(SpyNumber:Int)

    fun StartGame()

    fun DisplayOneRole()

    fun EndGame()

}