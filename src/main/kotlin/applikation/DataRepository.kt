package applikation

import domain.User
import domain.Word

interface DataRepository {
    fun getAllUsers(): List<User>
    fun getAllWords(): List<Word>
    fun getWord(): Word?
    fun setWord(word: Word)
    fun setWords(wordList: List<Word>)
    fun setUser(createUsers: List<User>)
}