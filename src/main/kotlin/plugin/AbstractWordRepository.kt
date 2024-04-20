package plugin

import domain.Word
import applikation.WordRepository

abstract class AbstractWordRepository : WordRepository {

    abstract fun getWords(): Array<String>

    override fun loadWords(): List<Word> {
        val wordsArray = getWords()
        val words = mutableListOf<Word>()
        for ((index, word) in wordsArray.withIndex()) {
            words.add(createWord(index + 1, word))
        }
        return words
    }

    override fun createWord(wordId: Int, word: String): Word {
        return Word(wordId, word)
    }

    override fun getRandomWord(words: List<Word>): Word {
        if (words.isEmpty()) {
            throw IllegalStateException("No words available")
        }
        return words.random()
    }


}