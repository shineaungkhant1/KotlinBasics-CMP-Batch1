package org.example

fun main() {

    val normalString: String = "This is CMP.\nWill Replace with Flutter"
    println(normalString)

    val rawString: String = """This is CMP.
        Will Replace with Flutter""".trimIndent()

    println(rawString)

    // String Templates
    val age = 24
    println("I am ${(age*2) - 24} years old")

    // String operations
    val movieName = "Wolverine"
    println(movieName.length)
    println(movieName.uppercase())
    println(movieName.lowercase())

    val student = "Shine Aung Khant"
    println(student.replace("Shine", "Ko Shine"))
    println(student)

    val stringWithSpace = "   Hello World   "
    println(stringWithSpace.trim())
    println(stringWithSpace)

    val programmingLanguages = "Kotlin, Java, Dart, JavaScript"
    val languages : List<String> = programmingLanguages.split(",")
    println(languages)

}