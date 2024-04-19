package plugin

import domain.Player
import domain.Spy
import domain.User
import applikation.UserRepository


class ImpUserRepository : UserRepository {
    override fun createSpy(spyId: Int): Spy {
        return Spy(spyId,"Spy $spyId")
    }

    override fun createPlayer(playerId: Int): Player {
        return Player(playerId, "Player $playerId")
    }

    override fun createUsers(numberOfSpies: Int, numberOfPlayers: Int): List<User> {
        val users = mutableListOf<User>()
        for (i in 1..numberOfSpies) {
            users.add(createSpy(i))

        }
        for (i in 1..numberOfPlayers) {
            users.add(createPlayer(i))
        }
        return users
    }



    override fun displayAllUserRoles(userList: List<User>) {
        userList.forEach { user ->
            println("${user.username}: ")
            user.displayRole()
        }
    }

    override fun selctRandomUser(userList: MutableList<User>): User {
        val randomIndex = (0..<userList.size).random()
        return userList.removeAt(randomIndex)
    }
}