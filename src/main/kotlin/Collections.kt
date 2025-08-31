package org.example

fun main (){
    val numbers = listOf(1,2,3,4,5)
    println(numbers[2])
    println(numbers)

    val mutableNumbers = mutableListOf(1,2,3)
    mutableNumbers.add(4)
    mutableNumbers.add(0,0)
    println(mutableNumbers)
    mutableNumbers.remove(2)
    println(mutableNumbers)

    val numberSet = setOf(1,2,3,4,5,6,7)
    println(numberSet)

    val mutableNumbersSet = mutableSetOf(1,2,3,4,5)
    mutableNumbersSet.add(6)
    mutableNumbersSet.remove(5)
    println(mutableNumbersSet)

    val scores = mapOf(
        "Man Utd" to 2,
        "Arsenal" to 6,
        "Chelsea" to 4
    )

    println(scores)

    println(scores["Arsenal"])

    val grades = mutableMapOf(
        "John" to "85",
        "Mary" to "56",
    )
    grades["Jack"] = "67"
    println(grades)
    grades.remove("Mary")
    println(grades)

    // List Operations
    val newNumbers = listOf(1,2,3,4,5)
    val doubleNumbers =newNumbers.map {
        "Doubled number : ${it * 2}"
    }
    println("Double Numbers: $doubleNumbers")

    // Filter
    val newNumbers2 = listOf(1,2,3,4,5,6,7,8,9,10)
    val evenNumbers = newNumbers2.filter {
        it % 2 == 0
    }
    println("Even Numbers: $evenNumbers")

    // Take, Take Last
    println(newNumbers2.take(2))
    println(newNumbers2.takeLast(2))

    // Drop, Drop Last
    println(newNumbers2.drop(2))
    println(newNumbers2.dropLast(2))

    // Distinct
    val numbersWithDuplicates = listOf(1,2,2,3,4,4,5)
    println(numbersWithDuplicates.distinct())

    // First, FirstOrNull
    val names = listOf("John", "Jane", "Jack")
    println(names.first())

    val emptyList = listOf<String>()
    println(emptyList.firstOrNull())

    println(names.count())

    val newNumbers3 = listOf(1,2,3,4,5)
    println(newNumbers3.sum())
}