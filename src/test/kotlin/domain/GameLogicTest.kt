package domain


import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach

import kotlin.test.assertEquals
import kotlin.test.assertTrue
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito.*

class GameLogicTest {

    private lateinit var wordRepository: WordRepository
    private lateinit var dataRepository: DataRepository
    private lateinit var userRepository: UserRepository
    private lateinit var gameLogic: GameLogic

    @BeforeEach
    fun setUp() {
        wordRepository = mock(WordRepository::class.java)
        dataRepository = mock(DataRepository::class.java)
        userRepository = mock(UserRepository::class.java)
        gameLogic = GameLogic(wordRepository, dataRepository, userRepository)
    }
    @Test
    fun initializeGame() {
        // Arrange
        val numberOfSpies = 2
        val numberOfUsers = 5
        val numberOfPlayers = numberOfUsers - numberOfSpies
        val usersList = mutableListOf<User>(Player(1, "Player 1"), Player(2, "Player 2"), Spy(3, "Spy 1"), Spy(4, "Spy 2"), Spy(5, "Spy 3"))

        // Mocking wordRepository and dataRepository
        val word = Word(1, "TestWord")
        `when`(wordRepository.getRandomWord(any())).thenReturn(word)
        `when`(dataRepository.setUser(any())).thenReturn(Unit)
        `when`(dataRepository.getAllUsers()).thenReturn(usersList)

        // Act
        gameLogic.initializeGame(numberOfSpies, numberOfUsers)

        // Assert
        verify(dataRepository).setUser(usersList)
        verify(dataRepository).setWord(word)
        assertEquals(usersList, gameLogic.users)
    }

    @Test
    fun displayOneRole() {
    }

    @Test
    fun endGame() {
    }
}