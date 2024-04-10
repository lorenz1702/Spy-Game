package applikation

import domain.Player
import domain.User

class ImpCoreFunktions(private var Game:GameRepository) : CoreFunktions {
    private var NumberOfUsers :Int = 0
    private var NumberOfSpys :Int = 0
    private var users = mutableListOf<User>()

    override fun NumberOfUsers(UserNumber: Int) {
        this.NumberOfUsers = UserNumber
    }

    override fun NumberOfSpys(SpyNumber: Int) {
        if (this.NumberOfUsers <= SpyNumber) {
            throw IllegalArgumentException("SpyNumber is not greater than the Number of Users or the User Number is not set")
        } else {
            this.NumberOfSpys = SpyNumber
        }

    }

    override fun StartGame() {
        val NumberOfPlayers = this.NumberOfUsers-this.NumberOfSpys
        Game.createUsers(this.NumberOfSpys, NumberOfPlayers)
        Game.LoadWords()
        Game.setWord(Game.getRandomWord())
        this.users = Game.getAllUser().toMutableList()

    }

    override fun DisplayOneRole() {
        fun displayOneRole(users: MutableList<User>) {
            if (users.isEmpty()) {
                println("No more users left.")
                return
            }

            val randomIndex = (0 until users.size).random()
            val randomUser = users.removeAt(randomIndex)

            println("${randomUser.username}:")
            randomUser.displayRole()
            if (randomUser is Player) {
                 println("Word: ${Game.getWord()}")  // Print the word if the user is a player and not a spy
            }
        }
    }

    override fun EndGame() {
        Game.userdisplaythereRole()
    }

}