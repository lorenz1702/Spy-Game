package domain

class Word (
    val id: Int,
    val name: String
){


    fun displayToPlayer(player: Player){
        println("The word is: $name")
    }
}

interface DisplayWordToPlayerUseCase{
    fun displayWordToPlayer(word:Word)

    fun createWord(NewWord: String)
}
