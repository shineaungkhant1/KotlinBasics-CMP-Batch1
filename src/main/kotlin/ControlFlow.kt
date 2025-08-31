package org.example

fun main(){
    // if - else

    val score = 85

    if(score >= 85){
        println("Distinction")
    } else if(score >= 60){
        println("Credit")
    } else if(score >= 50){
        println("Passed")
    } else {
        println("Failed")
    }

    val creditScore = 1000
    val financialStatus = if(creditScore >= 500) "Rich" else "Poor"
    println(financialStatus)


    // when
    val day = 3
    when(day){
        1 -> println("Monday")
        2 -> println("Tuesday")
        3 -> println("Wednesday")
        4 -> println("Thursday")
        5 -> println("Friday")
        6 -> println("Saturday")
        7 -> println("Sunday")
        else -> println("Invalid Day")
    }

    println()

    // when as expression
    val age = 24
   val ageStatus = when{
        age < 20 -> "Young"
        age >= 30 -> "Old"
        else -> "Adult"
    }
    println(ageStatus)

    println()

    // Loop
    for (i in 0..4){
        println("i = $i")
    }

    println()

    for (j in 0..5 step 2){
        println("j = $j")
    }

    println()

    val languages = listOf("Java", "Python", "Python", "Dart", "Kotlin")
    for (language in languages) {
        println(language)
    }

    println()

    // While Loop

    var count = 0
    while (count < 5) {
        println("count = $count")
        count++
    }
    println()

    var number = 10
    do {
        println(number)
        number--
    } while (number > 10)
}

