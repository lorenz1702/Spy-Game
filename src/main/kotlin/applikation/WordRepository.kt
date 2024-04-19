package applikation

import domain.Word

interface WordRepository {
    fun loadWords():List<Word>
    fun createWord(wordId: Int, word: String): Word
    fun getRandomWord(words: List<Word>): Word
}