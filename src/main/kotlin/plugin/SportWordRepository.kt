package plugin

class SportWordRepository : AbstractWordRepository() {
    override fun getWords(): Array<String> {
        return arrayOf(
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
    }
}