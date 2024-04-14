package domain

interface UserRepository {
    fun createSpy(spyId: Int): Spy
    fun createPlayer(playerId: Int): Player
    fun createUsers(numberOfSpies: Int, numberOfPlayers: Int): List<User>
    fun displayAllUserRoles(userList:List<User>)
}