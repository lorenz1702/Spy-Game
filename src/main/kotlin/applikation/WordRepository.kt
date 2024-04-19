package applikation

import domain.Word

interface WordRepository {
    fun loadKlimacticWords():List<Word>
    fun loadSportWords():List<Word>
    fun createWord(wordId: Int, word: String): Word
    fun getRandomWord(words: List<Word>): Word
}