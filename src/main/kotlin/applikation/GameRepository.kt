package applikation
import domain.*
interface GameRepository {
    // Methods for interacting with player data
    fun getUserById(UserId: Int): User
    fun getAllUser(): List<User>

    // Methods for interacting with location data
    fun getWordById(wordId: Int): Word
    fun getAllWords(): Word

    // Methods for game actions

    fun createPlayer(PlayerId: Int):Player

    fun createSpy(SpyId: Int):Spy

    fun createWord(WordId: Int, Word: String):Word

    fun getRandomWord():Word

}
