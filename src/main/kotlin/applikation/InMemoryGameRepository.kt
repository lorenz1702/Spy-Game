package applikation

import domain.*

class InMemoryGameRepository : GameRepository {
    // Mock data storage
    private val users = mutableListOf<User>()
    private val players = mutableListOf<Player>()
    private val spies = mutableListOf<Spy>()
    private val words = mutableListOf<Word>()
    private var word: Word? = null

    // Add players to the repository
    fun addPlayer(player: Player) {
        players.add(player)
        users.add(player)
    }

    // Add spies to the repository
    fun addSpy(spy: Spy) {
        spies.add(spy)
        users.add(spy)
    }

    // Set the secret word
    fun setWord(word: Word) {
        this.word = word
    }

    // Implement methods from the GameRepository interface

    override fun getAllWords(): Word {
        TODO("Not yet implemented")
    }

    override fun createPlayer(PlayerId: Int): Player {
        return Player(
            PlayerId,
            "Player $PlayerId"
        )
    }

    override fun createSpy(SpyId: Int): Spy {
        return Spy(SpyId,"Spy $SpyId")
    }

    override fun createWord(WordId: Int, Word: String): Word {
        return Word(WordId, Word)
    }


    override fun getUserById(UserId: Int): User {
        return spies.firstOrNull { it.id == UserId }
            ?: throw IllegalArgumentException("Spy not found with id $UserId")
    }

    override fun getAllUser(): List<User> {
        return users.toList()
    }

    override fun getWordById(wordId: Int): Word {
        TODO("Not yet implemented")
    }

    override fun getRandomWord(): Word {
        TODO("Not yet implemented")
    }
}