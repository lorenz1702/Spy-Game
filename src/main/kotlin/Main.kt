import applikation.*


fun getGreeting(itemToGreet: String) {
    val msg = "Hello $itemToGreet"
    println(msg)
}



fun main() {
    val Game = InMemoryGameRepository()
    val Player = Game.createPlayer(1)
    println("test")
}


