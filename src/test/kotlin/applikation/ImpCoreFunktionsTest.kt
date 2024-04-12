package applikation

import domain.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

import kotlin.test.assertEquals

import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito
import org.mockito.Mockito.*
import kotlin.random.Random

class ImpCoreFunktionsTest {

    var gameRepository: GameRepository = InMemoryGameRepository()
    var impCoreFunktions: ImpCoreFunktions = ImpCoreFunktions(gameRepository)

    @BeforeEach
    fun setUp() {
        val gameRepository  = InMemoryGameRepository()
        val impCoreFunktions = ImpCoreFunktions(gameRepository)
    }

    @Test
    fun numberOfUsers() {
        // Arrange
        val userNumber = 5

        // Act
        impCoreFunktions.NumberOfUsers(userNumber)

        // Assert
        assertEquals(userNumber, impCoreFunktions.NumberOfUsers)
    }

    @Test
    fun numberOfSpys() {
        // Arrange
        val SpyNumber = 2
        val userNumber = 6

        impCoreFunktions.NumberOfUsers(userNumber)

        // Act
        impCoreFunktions.NumberOfSpys(SpyNumber)

        // Assert
        assertEquals(SpyNumber, impCoreFunktions.NumberOfSpys)
    }

    @Test
    fun startGame() {
        // Arrange
        val SpyNumber = 0
        val userNumber = 2
        impCoreFunktions.NumberOfUsers(userNumber)
        impCoreFunktions.NumberOfSpys(SpyNumber)

        val usersList = mutableListOf<User>(Player(1,"Player 1"), Player(2, "Player 2"))
        // Call the method under test
        impCoreFunktions.StartGame()

        // Verify that the necessary interactions occurred

        assertTrue((gameRepository.getWord()?.name) != null) // Asserts that str1 is not null
        assertEquals(usersList.map { it.username }, impCoreFunktions.users.map { it.username })
    }

    @Test
    fun displayOneRole() {
        // Arrange
        gameRepository = mock()
        impCoreFunktions = ImpCoreFunktions(gameRepository)
        val player1 = Player(1, "Player 1")
        val player2 = Player(2, "Player 2")
        val spy1 = Spy(3, "Spy 1")
        val usersList = mutableListOf<User>(player1, player2, spy1)

        impCoreFunktions.users = usersList.toMutableList()


        // Mocking gameRepository to return a word
        `when`(gameRepository.getWord()).thenReturn(Word(1,"TestWord"))



        // Act
        impCoreFunktions.DisplayOneRole()

        // Assert
        // Verify println statements using Mockito verify


        // Verify that the removed user is not in usersList anymore
        // Assert
        assertEquals(usersList.size - 1, impCoreFunktions.users.size)

    }




    @Test
    fun endGame() {

        // Arrange
        gameRepository = mock()
        impCoreFunktions = ImpCoreFunktions(gameRepository)
        val player1 = Player(1, "Player 1")
        val player2 = Player(2, "Player 2")
        val spy1 = Spy(3, "Spy 1")
        val usersList = mutableListOf<User>(player1, player2, spy1)

        impCoreFunktions.users = usersList.toMutableList()

        // Act
        impCoreFunktions.EndGame()

        // Assert
        verify(gameRepository, times(1)).userdisplaythereRole()
    }
}