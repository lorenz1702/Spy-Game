package plugin

import domain.Word

class KlimacticWordRepository : AbstractWordRepository() {
    override fun getWords(): Array<String> {
        return arrayOf(
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
    }
}