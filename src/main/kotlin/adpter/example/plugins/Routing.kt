package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import applikation.*

fun Application.configureRouting() {
    routing {

        val CoreFunktions = ImpCoreFunctions()

        // Define routes to call backend functions

        // Route to set the number of users
        post("/setNumberOfUsers/{userNumber}") {
            val userNumber = call.parameters["userNumber"]?.toIntOrNull()
            if (userNumber != null) {
                CoreFunktions.NumberOfUsers(userNumber)
                call.respond("Number of users set to: $userNumber")
            } else {
                call.respond("Invalid user number.")
            }
        }

        // Route to set the number of spies
        post("/setNumberOfSpies/{spyNumber}") {
            val spyNumber = call.parameters["spyNumber"]?.toIntOrNull()
            if (spyNumber != null) {
                CoreFunktions.NumberOfSpys(spyNumber)
                call.respond("Number of spies set to: $spyNumber")
            } else {
                call.respond("Invalid spy number.")
            }
        }

        // Route to start the CoreFunktions
        get("/startGame") {
            CoreFunktions.StartGame()
            call.respond("Game started.")
        }

        // Route to display one role
        get("/displayOneRole") {
            call.respond(CoreFunktions.DisplayOneRole())
            call.respond("Displayed one role.")
        }

        // Route to end the CoreFunktions
        get("/endGame") {
            call.respond(CoreFunktions.EndGame())
            call.respond("Game ended.")
        }

    }
}
