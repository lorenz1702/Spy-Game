package applikation

import domain.Player
import domain.Spy
import domain.User

interface UserRepository {
    fun createSpy(spyId: Int): Spy
    fun createPlayer(playerId: Int): Player
    fun createUsers(numberOfSpies: Int, numberOfPlayers: Int): List<User>
    fun displayAllUserRoles(userList:List<User>)
    fun selctRandomUser(userList: MutableList<User>): User
}