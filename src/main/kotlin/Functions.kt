package org.example


fun greet() {
    println("Hello")
}

fun saySomething(message: String = "Hello CMP") {
    println(message)
}

fun add(firstNum: Int, secondNum: Int): Int {
    return firstNum + secondNum
}

val onValueChange: () -> Unit = {
    println("Value Changed")
}

fun onAction(action: () -> Unit) {
    println("Calling the function passed as argument:")
    action()
}

// Factory Functions - type - {print("")}

fun createLogger(type: String): (String) -> Unit {
    return when (type) {
        "console" -> { message -> println("Console ======> $message") }
        "file" -> { message -> println("File ======> $message") }
        "network" -> { message -> println("Network ======> $message") }
        else -> { message -> println("Invalid Type") }
    }
}

fun main() {

    greet()

    saySomething("Hello KMP")

    println(add(3, 5))

    onValueChange()

    onAction(action = {
        println("Action")
    })

    createLogger(type = "console").invoke("Function exercise")
}