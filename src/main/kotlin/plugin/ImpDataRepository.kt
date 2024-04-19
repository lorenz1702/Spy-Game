package plugin

import applikation.DataRepository
import domain.*

class ImpDataRepository : DataRepository {
    private var users = mutableListOf<User>()

    private var words = mutableListOf<Word>()
    private var word: Word? = null

    override fun getAllUsers(): List<User> {
        return users.toList()
    }

    override fun getAllWords(): List<Word> {
        return this.words
    }


    override fun getWord(): Word? {
        return this.word
    }

    override fun setWord(word: Word) {
        this.word = word
    }

    override fun setUser(createUsers: List<User>) {
        users = createUsers.toMutableList()
    }
}