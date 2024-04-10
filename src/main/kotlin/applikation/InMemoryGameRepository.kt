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
    override fun setWord(word: Word) {
        this.word = word
    }

    override fun getWord(): Word? {
        return this.word
    }


    // Implement methods from the GameRepository interface

    override fun createPlayer(PlayerId: Int): Player {
        return Player(
            PlayerId,
            "Player $PlayerId"
        )
    }

    override fun createSpy(SpyId: Int): Spy {
        return Spy(SpyId,"Spy $SpyId")
    }

    override fun LoadWords() {
        val geographicZones = arrayOf(
            "Arctic",
            "Antarctic",
            "Tundra",
            "Taiga",
            "Temperate Forest",
            "Tropical Rainforest",
            "Grassland",
            "Desert",
            "Savanna",
            "Mediterranean"
        )

        words.clear() // Clear existing words
        for ((index, zone) in geographicZones.withIndex()) {
            words.add(createWord(index + 1, zone))
        }
    }

    override fun createWord(WordId: Int, Word: String): Word {

        return Word(WordId, Word)
    }

    override fun getAllUser(): List<User> {
        return users.toList()
    }



    override fun getRandomWord(): Word {
        if (words.isEmpty()) {
            throw IllegalStateException("No words available")
        }
        return words.random()
    }

    override fun createUsers(numberOfSpies: Int, numberOfPlayers: Int) {
        for (i in 1..numberOfSpies) {
            createSpy(i)
        }
        for (i in 1..numberOfPlayers) {
            createPlayer(i)
        }
    }

    override fun userdisplaythereRole() {
        users.forEach { user ->
            println("${user.username}: ")
            user.displayRole()
        }
    }
}