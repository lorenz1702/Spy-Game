package plugin

import domain.Word
import applikation.WordRepository

class ImpWordRepository : WordRepository {


    override fun loadKlimacticWords(): List<Word> {
        val words = mutableListOf<Word>()
        val geographicZones = arrayOf(
            "Arctic",
            "Antarctic",
            "Tundra",
            "Taiga",
            "Temperate Forest",
            "Tropical Rainforest",
            "Grassland",
            "Desert",
            "Savanna",
            "Mediterranean"
        )

        words.clear() // Clear existing words
        for ((index, zone) in geographicZones.withIndex()) {
            words.add(createWord(index + 1, zone))
        }
        return words
    }

    override fun loadSportWords(): List<Word> {
        val words = mutableListOf<Word>()
        val sportWords = arrayOf(
            "Fußball",
            "Basketball",
            "Tennis",
            "Volleyball",
            "Schwimmen",
            "Laufen",
            "Leichtathletik",
            "Boxen",
            "Handball",
            "Rugby",
            "Golf",
            "Hockey",
            "Tischtennis",
            "Badminton",
            "Radfahren",
            "Skifahren",
            "Snowboarden",
            "Klettern",
            "Tauchen",
            "Yoga"
        )
        words.clear() // Clear existing words
        for ((index, zone) in sportWords.withIndex()) {
            words.add(createWord(index + 1, zone))
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