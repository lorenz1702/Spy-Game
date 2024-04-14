package domain

interface WordRepository {
    fun loadWords():List<Word>
    fun createWord(wordId: Int, word: String): Word
    fun getRandomWord(words: List<Word>): Word
}