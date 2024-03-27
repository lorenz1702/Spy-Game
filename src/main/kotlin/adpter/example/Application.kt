package com.example



import com.example.plugins.configureDatabases
import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

import applikation.*



fun getGreeting(itemToGreet: String) {
    val msg = "Hello $itemToGreet"
    println(msg)
}



fun main() {
    val Game = InMemoryGameRepository()
    val Player = Game.createPlayer(1)
    println("test")

    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureDatabases()
    configureRouting()
}
