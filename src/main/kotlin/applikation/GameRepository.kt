package applikation
import domain.*
interface GameRepository {
    // Methods for interacting with player data
    fun getAllUser(): List<User>

    // Methods for interacting with location data

    // Methods for game actions

    fun createPlayer(PlayerId: Int):Player

    fun createSpy(SpyId: Int):Spy

    fun createWord(WordId: Int, Word: String):Word

    fun getRandomWord():Word

    fun createUsers(NumberofSpys: Int, NumberofPlayers: Int)

    fun userdisplaythereRole()

}
