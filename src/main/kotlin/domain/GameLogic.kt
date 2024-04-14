package domain

class GameLogic(private val wordRepository: WordRepository, private val dataRepository: DataRepository, private val userRepository: UserRepository) {
    var users = mutableListOf<User>()

    fun initializeGame(numberofSpies:Int, numberofUsers:Int){
        val numberofPlayers = numberofUsers-numberofSpies
        dataRepository.setUser(userRepository.createUsers(numberofSpies, numberofPlayers))
        dataRepository.setWord(wordRepository.getRandomWord(wordRepository.loadWords()))
        this.users = dataRepository.getAllUsers().toMutableList()
    }

    fun displayOneRole(){
        if (users.isEmpty()) { return }
        val randomIndex = (0..<users.size).random()
        val randomUser = users.removeAt(randomIndex)

        println("${randomUser.username}:")
        randomUser.displayRole()
        if (randomUser is Player) {
            println("Word: ${dataRepository.getWord()?.name}")  // Print the word if the user is a player and not a spy
        }
    }

    fun endGame(){
        userRepository.displayAllUserRoles(dataRepository.getAllUsers().toMutableList())
    }

    fun getDataRepository(): DataRepository{
        return dataRepository
    }

    fun getUserRepository(): UserRepository{
        return userRepository
    }

    fun getWordRepository(): WordRepository{
        return wordRepository
    }
}