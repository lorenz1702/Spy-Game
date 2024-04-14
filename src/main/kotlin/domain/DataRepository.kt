package domain

interface DataRepository {
    fun getAllUsers(): List<User>
    fun getAllWords(): List<Word>
    fun getWord(): Word?
    fun setWord(word: Word)
    fun setUser(createUsers: List<User>)
}