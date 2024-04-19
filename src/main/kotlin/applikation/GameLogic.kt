package applikation

import domain.Player
import domain.User

class GameLogic(private val wordRepository: WordRepository, private val dataRepository: DataRepository, private val userRepository: UserRepository) {
    var users = mutableListOf<User>()


    fun choseCategories(chosenCategories:Boolean){
        if (chosenCategories){
            dataRepository.setWords(wordRepository.loadKlimacticWords())
            return
        }

        dataRepository.setWords(wordRepository.loadSportWords())
    }

    fun initializeGame(numberofSpies:Int, numberofUsers:Int){
        val numberofPlayers = numberofUsers-numberofSpies
        dataRepository.setUser(userRepository.createUsers(numberofSpies, numberofPlayers))
        dataRepository.setWord(wordRepository.getRandomWord(dataRepository.getAllWords()))
        this.users = dataRepository.getAllUsers().toMutableList()
    }

    fun displayOneRole() {
        if (users.isEmpty()) { return }

        val randomUser = userRepository.selctRandomUser(users)
        users.remove(randomUser)
        randomUser.displayRole()
        if (randomUser is Player) {
            printPlayerWord(randomUser)
        }
    }

    private fun printPlayerWord(player: Player) {
        println("Word: ${dataRepository.getWord()?.name}")
    }


    fun endGame(){
        userRepository.displayAllUserRoles(dataRepository.getAllUsers().toMutableList())
    }

    fun getDataRepository(): DataRepository {
        return dataRepository
    }

    fun getUserRepository(): UserRepository {
        return userRepository
    }

    fun getWordRepository(): WordRepository {
        return wordRepository
    }
}