package com.example



import com.example.plugins.configureDatabases
import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

import plugin.ImpCoreFunctions


fun getGreeting(itemToGreet: String) {
    val msg = "Hello $itemToGreet"
    println(msg)
}



fun main() {

    val game = ImpCoreFunctions()
    game.NumberOfUsers(5)
    println("Helloworld")
    game.NumberOfSpys(2)
    game.StartGame()
    game.DisplayOneRole()
    game.EndGame()


    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureDatabases()
    configureRouting()
}
