package applikation

import domain.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class InMemoryGameRepositoryTest {

    @Test
    fun setWord() {
        val game = InMemoryGameRepository()
        val word = Word(1, "hello")
        val expected = word
        game.setWord(word)
        assertEquals(expected, game.getWord())
    }

    @Test
    fun getWord() {
        val game = InMemoryGameRepository()
        val word = Word(1, "hello")
        val expected = word
        game.setWord(word)
        assertEquals(expected, game.getWord())
    }

    @Test
    fun createPlayer() {
        // Arrange
        val game = InMemoryGameRepository()
        val playerId = 1
        val expectedPlayer = Player(playerId, "Player 1")

        // Act
        val actualPlayer = game.createPlayer(playerId)

        // Assert
        assertEquals(expectedPlayer.id, actualPlayer.id)
        assertEquals(expectedPlayer.username, actualPlayer.username)
    }

    @Test
    fun createSpy() {
        // Arrange
        val game = InMemoryGameRepository()
        val SpyId = 1
        val expectedSpy = Spy(SpyId, "Spy 1")

        // Act
        val actualSpy = game.createSpy(SpyId)

        // Assert
        assertEquals(expectedSpy.id, actualSpy.id)
        assertEquals(expectedSpy.username, actualSpy.username)
    }

    @Test
    fun loadWords() {
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

        val words = mutableListOf<Word>()

        // Act
        val game = InMemoryGameRepository()
        game.LoadWords()

        // Assert
        assertEquals(geographicZones.size, words.size)
        for ((index, word) in words.withIndex()) {
            assertEquals(index + 1, word.id)
            assertEquals(geographicZones[index], word.name)
        }
    }

    @Test
    fun createWord() {
        // Arrange
        val wordId = 1
        val wordName = "TestWord"

        // Act
        val game = InMemoryGameRepository()
        val createdWord = game.createWord(wordId, wordName)

        // Assert
        assertEquals(wordId, createdWord.id)
        assertEquals(wordName, createdWord.name)
    }

    @Test
    fun getAllUser() {
        // Arrange
        val users = listOf(
            Player(1, "Alice"),
            Player(2, "Bob"),
            Spy(3, "Charlie")
        )

        // Act
        val game = InMemoryGameRepository()
        game.addPlayer(Player(1, "Alice"))
        game.addPlayer(Player(2, "Bob"))
        game.addSpy(Spy(3, "Charlie"))
        val userList = game.getAllUser()

        // Assert
        assertEquals(users.size, userList.size)
        assertEquals(users, userList)
    }

    @Test
    fun getRandomWord() {
        // Arrange
        val word1 = Word(1, "TestWord1")
        val word2 = Word(2, "TestWord2")
        val word3 = Word(3, "TestWord3")
        val words = listOf(word1, word2, word3)


        // Act
        val game = InMemoryGameRepository()
        val randomWord = game.getRandomWord()

        // Assert
        assertTrue(words.contains(randomWord))
    }



    @Test
    fun createUsers() {
        // Arrange
        val users = listOf(
            Player(1, "Player 1"),
            Player(2, "Player 2"),
            Spy(3, "Spy 1")
        )
        val game = InMemoryGameRepository()
        game.createUsers(1,2)

        assertEquals(users, game.getAllUser())


    }

    @Test
    fun userdisplaythereRole() {
        val game = InMemoryGameRepository()
        game.createUsers(1,2)
        game.userdisplaythereRole()


    }
}